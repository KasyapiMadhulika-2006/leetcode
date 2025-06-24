class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        
        // Step 1: Find all indices where nums[i] == key
        List<Integer> keyIndices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                keyIndices.add(i);
            }
        }

        // Step 2: Mark all indices that are within k distance from any key index
        boolean[] isKDistance = new boolean[n];
        for (int idx : keyIndices) {
            int start = Math.max(0, idx - k);
            int end = Math.min(n - 1, idx + k);
            for (int i = start; i <= end; i++) {
                isKDistance[i] = true;
            }
        }

        // Step 3: Collect all marked indices
        for (int i = 0; i < n; i++) {
            if (isKDistance[i]) {
                result.add(i);
            }
        }

        return result;
    }
}