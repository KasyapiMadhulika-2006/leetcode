class Solution {
    public boolean isAnagram(String s, String t) {
        //Check the lengths of both the strings
        if(s.length() != t.length()){
            return false;
        }
        // Check the frequencies
        int[] charCounts = new int[26];
        //Iterating through loop
        //increment for s and decrement for t
        for(int i = 0; i < s.length();i++){
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }
        // check if all zeros are not 
        for(int count:charCounts){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}