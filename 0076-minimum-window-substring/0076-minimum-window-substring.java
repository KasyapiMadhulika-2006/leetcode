class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in t
        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int required = tFreq.size(); // Number of unique characters in t
        int formed = 0; // To keep track of how many unique characters in t are present in current 
        Map<Character, Integer> windowCounts = new HashMap<>();

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (tFreq.containsKey(c) && windowCounts.get(c).intValue() == tFreq.get(c).intValue()) {
                formed++;
            }

            // Try to shrink the window from the left
            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (tFreq.containsKey(leftChar) && windowCounts.get(leftChar).intValue() < tFreq.get(leftChar).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
        System.out.println(sol.minWindow("a", "a"));                // Output: "a"
        System.out.println(sol.minWindow("a", "aa"));  
    }
}