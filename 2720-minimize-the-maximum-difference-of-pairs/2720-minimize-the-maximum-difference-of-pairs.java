class Solution {
    public int minimizeMax(int[] nums, int p) {
         Arrays.sort(nums);  // Sort the array to make adjacent differences meaningful
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];  // Maximum possible difference
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFormPairs(nums, p, mid)) {
                result = mid;
                right = mid - 1;  // Try to minimize the maximum difference
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    // Helper function to check if we can form at least 'p' pairs with max difference ≤ diff
    private boolean canFormPairs(int[] nums, int p, int diff) {
        int count = 0;
        int i = 1;

        while (i < nums.length) {
            if (nums[i] - nums[i - 1] <= diff) {
                count++;
                i += 2;  // Skip the next index since it's already used
            } else {
                i++;
            }
            if (count >= p) {
                return true;
            }
        }

        return false;
    }
}