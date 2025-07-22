class Solution {
    public int maximumUniqueSubarray(int[] nums) {
         int left = 0, right = 0;
        int maxScore = 0, currentSum = 0;
        HashSet<Integer> seen = new HashSet<>();

        while (right < nums.length) {
            if (!seen.contains(nums[right])) {
                seen.add(nums[right]);
                currentSum += nums[right];
                maxScore = Math.max(maxScore, currentSum);
                right++;
            } else {
                // Remove elements until duplicate is removed
                while (nums[left] != nums[right]) {
                    seen.remove(nums[left]);
                    currentSum -= nums[left];
                    left++;
                }
                // Remove the duplicate itself
                seen.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
        }

        return maxScore;
    }
}