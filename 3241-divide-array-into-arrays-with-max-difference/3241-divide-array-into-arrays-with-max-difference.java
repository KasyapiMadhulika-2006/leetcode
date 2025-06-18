class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);  // Sort the array for greedy grouping
        int n = nums.length;
        if (n % 3 != 0) return new int[0][0];

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i += 3) {
            int a = nums[i], b = nums[i + 1], c = nums[i + 2];
            if (c - a > k) {
                return new int[0][0]; // Difference exceeds k
            }
            result.add(new int[]{a, b, c});
        }

        // Convert list to 2D array
        return result.toArray(new int[result.size()][]);
    }
}