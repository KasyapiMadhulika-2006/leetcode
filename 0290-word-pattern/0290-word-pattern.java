class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            String val = words[i];

            if (charToWord.containsKey(key)) {
                if (!charToWord.get(key).equals(val)) {
                    return false;
                }
            } else {
                charToWord.put(key, val);
            }

            if (wordToChar.containsKey(val)) {
                if (wordToChar.get(val) != key) {
                    return false;
                }
            } else {
                wordToChar.put(val, key);
            }
        }
        return true;
    }
}
