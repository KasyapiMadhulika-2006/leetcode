class Solution {
    public int maximumDifference(int[] nums) {
        int minVal = nums[0];  // Initialize with the first element
        int maxDiff = -1;      // Default result if no valid pair is found

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > minVal) {
                maxDiff = Math.max(maxDiff, nums[i] - minVal);
            } else {
                minVal = nums[i]; // Update the minimum value
            }
        }

        return maxDiff;
    }
}