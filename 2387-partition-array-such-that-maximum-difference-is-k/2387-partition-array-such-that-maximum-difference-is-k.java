class Solution {
    public int partitionArray(int[] nums, int k) {
         Arrays.sort(nums);

        int count = 1; // At least one subsequence is needed
        int start = nums[0]; // Starting point of the current subsequence

        for (int i = 1; i < nums.length; i++) {
            // If the difference exceeds k, start a new subsequence
            if (nums[i] - start > k) {
                count++;
                start = nums[i]; // Reset the start of the new subsequence
            }
        }

        return count;
    }
    }
