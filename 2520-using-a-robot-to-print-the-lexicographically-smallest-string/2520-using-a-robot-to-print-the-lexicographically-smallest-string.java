class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        int[] minSuffix = new int[n];
        minSuffix[n - 1] = s.charAt(n - 1);

        // Fill minSuffix[i] = min character from s[i..n-1]
        for (int i = n - 2; i >= 0; i--) {
            minSuffix[i] = (char)Math.min(s.charAt(i), minSuffix[i + 1]);
        }

        Stack<Character> t = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            t.push(s.charAt(i));
            // Check whether we can pop from t to result
            while (!t.isEmpty() && t.peek() <= minSuffix[i == n - 1 ? i : i + 1]) {
                result.append(t.pop());
            }
        }

        // Pop remaining characters from stack
        while (!t.isEmpty()) {
            result.append(t.pop());
        }

        return result.toString();
    }
}
    
