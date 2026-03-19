class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seennumbers = new HashSet<>();
        //Iterate through the array using for each loop
        for(int num : nums){
            //Check if it contains duplicate 
            if(seennumbers.contains(num)){
                return true;
            }
            seennumbers.add(num);
        }
        return false;
    }
}