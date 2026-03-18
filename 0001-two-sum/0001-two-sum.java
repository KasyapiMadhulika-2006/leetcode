class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Creating an hashmap to insert new indices 
        Map<Integer, Integer> map = new HashMap<>();
        // Iterate through the array
        for(int i = 0;i < nums.length;i++){
            // caluculating the complement to see the number to be present or not
            int complement = target - nums[i];
            // Check if the complement is already in the map
            if (map.containsKey(complement)){
                // if found then return the indices of the complemtn
                return new int[] {map.get(complement), i};
            }
            //Otherwise add into the map
            map.put(nums[i],i);
        }
        //Return an empty array if no solution is found
        return new int[] {};
    }
}