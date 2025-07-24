import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {

    private List<List<Integer>> adj;
    private int[] values;
    private int[] subtreeXor;
    private int[] tin;
    private int[] tout;
    private int timer;

    // Performs DFS to calculate subtree XOR sums and populate tin/tout arrays
    private void dfs(int u, int parent) {
        tin[u] = timer++; // Record entry time for node u
        subtreeXor[u] = values[u]; // Initialize subtree XOR with node's own value

        for (int v : adj.get(u)) {
            if (v == parent) {
                continue; // Avoid going back to parent
            }
            dfs(v, u); // Recursively call DFS for children
            subtreeXor[u] ^= subtreeXor[v]; // XOR sum of current node includes children's subtrees
        }
        tout[u] = timer++; // Record exit time for node u
    }

    // Checks if node u is an ancestor of node v using tin/tout times
    private boolean isAncestor(int u, int v) {
        // u is an ancestor of v if v's DFS traversal started after u's,
        // and v's DFS traversal finished before u's.
        return tin[u] < tin[v] && tout[u] > tout[v];
    }

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        this.values = nums;

        // Build adjacency list for the tree
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Initialize arrays for DFS results
        subtreeXor = new int[n];
        tin = new int[n];
        tout = new int[n];
        timer = 0;

        // Perform DFS starting from node 0 (arbitrarily chosen root)
        dfs(0, -1);

        // The total XOR sum of the entire tree is the subtree XOR sum of the root
        int totalXor = subtreeXor[0];

        int minScore = Integer.MAX_VALUE;

        // List to store the 'child' node of each edge when the tree is rooted at 0.
        // Cutting an edge (parent, child) isolates the subtree rooted at 'child'.
        List<Integer> cutNodesForEdges = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            // Determine which node is the child (deeper) in the DFS tree
            if (isAncestor(u, v)) { // u is parent of v
                cutNodesForEdges.add(v);
            } else { // v is parent of u
                cutNodesForEdges.add(u);
            }
        }

        // Iterate over all distinct pairs of edges
        int numEdges = edges.length;
        for (int i = 0; i < numEdges; i++) {
            for (int j = i + 1; j < numEdges; j++) {
                // Get the child nodes corresponding to the two edges being 'cut'
                int node1 = cutNodesForEdges.get(i);
                int node2 = cutNodesForEdges.get(j);

                int xor1, xor2, xor3;

                // Case 1: One cut node is an ancestor of the other
                if (isAncestor(node1, node2)) {
                    // node1 is an ancestor of node2
                    // Component 1: Subtree rooted at node2
                    xor1 = subtreeXor[node2];
                    // Component 2: The part of node1's subtree outside node2's subtree
                    xor2 = subtreeXor[node1] ^ subtreeXor[node2];
                    // Component 3: The rest of the tree outside node1's subtree
                    xor3 = totalXor ^ subtreeXor[node1];
                }
                else if (isAncestor(node2, node1)) {
                    // node2 is an ancestor of node1 (symmetric to the above)
                    // Component 1: Subtree rooted at node1
                    xor1 = subtreeXor[node1];
                    // Component 2: The part of node2's subtree outside node1's subtree
                    xor2 = subtreeXor[node2] ^ subtreeXor[node1];
                    // Component 3: The rest of the tree outside node2's subtree
                    xor3 = totalXor ^ subtreeXor[node2];
                }
                // Case 2: The two cut subtrees are disjoint
                else {
                    // Component 1: Subtree rooted at node1
                    xor1 = subtreeXor[node1];
                    // Component 2: Subtree rooted at node2
                    xor2 = subtreeXor[node2];
                    // Component 3: The total XOR sum excluding both subtrees
                    xor3 = totalXor ^ subtreeXor[node1] ^ subtreeXor[node2];
                }

                // Calculate the difference between max and min XOR sums for the three components
                int currentMax = Math.max(xor1, Math.max(xor2, xor3));
                int currentMin = Math.min(xor1, Math.min(xor2, xor3));
                minScore = Math.min(minScore, currentMax - currentMin);
            }
        }

        return minScore;
    }
}