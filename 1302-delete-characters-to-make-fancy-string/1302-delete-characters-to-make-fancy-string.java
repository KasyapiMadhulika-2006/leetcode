class Solution {
    public String makeFancyString(String s) {
         StringBuilder result = new StringBuilder();
        int count = 1;  // Start with 1 since the first char is always included

        result.append(s.charAt(0));  // Add the first character

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;  // Reset count for new character
            }

            if (count < 3) {
                result.append(s.charAt(i));   
            }
        }

        return result.toString();
    }
}