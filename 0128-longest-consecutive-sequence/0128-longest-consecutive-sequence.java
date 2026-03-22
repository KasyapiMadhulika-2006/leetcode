class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> numset = new HashSet<>();
        for(int i = 0; i  < nums.length;i++){
            numset.add(nums[i]);
        }
            int longSub = 1;
        
        for(int num: numset){
            if(numset.contains(num-1)){
                continue;
            }
            else{
                int currentno = num;
                int currentsub = 1;
                while(numset.contains(currentno+1)){
                    currentno++;
                    currentsub++;
                }
                longSub = Math.max(longSub,currentsub);
            }
        }
        return longSub;
    }
}
 