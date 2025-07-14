class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Map<Integer, Integer> pointsMap = new HashMap<>();
        int maxNum = 0;
         for (int num : nums) {
            pointsMap.put(num, pointsMap.getOrDefault(num, 0) + num);
            maxNum = Math.max(maxNum, num);
        }
        int [] dp = new int[maxNum +1];
        dp[0] = 0;
        dp[1] = pointsMap.getOrDefault(1,0);
        for(int i = 2; i <= maxNum; i++){
            int earn = pointsMap.getOrDefault(i,0);
            dp[i] = Math.max(dp[i-1],dp[i-2]+earn);
        }
        return dp[maxNum];
    
    }
}