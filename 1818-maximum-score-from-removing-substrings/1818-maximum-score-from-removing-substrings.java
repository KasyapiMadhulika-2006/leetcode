class Solution {
    public int maximumGain(String s, int x, int y) {
         if (x > y) {
            return getPoints(s, "a", "b", x, y);
        } else {
            return getPoints(s, "b", "a", y, x);
        }
    }

    private int getPoints(String s, String firstChar, String secondChar, int firstPoints, int secondPoints) {
        Stack<Character> stack = new Stack<>();
        int totalPoints = 0;

        // First pass to remove high priority pair (either "ab" or "ba")
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && 
                stack.peek() == firstChar.charAt(0) && 
                ch == secondChar.charAt(0)) {
                stack.pop();
                totalPoints += firstPoints;
            } else {
                stack.push(ch);
            }
        }

        // Build remaining string
        StringBuilder remaining = new StringBuilder();
        while (!stack.isEmpty()) {
            remaining.append(stack.pop());
        }
        remaining.reverse();

        // Second pass to remove the other pair
        stack.clear();
        for (char ch : remaining.toString().toCharArray()) {
            if (!stack.isEmpty() && 
                stack.peek() == secondChar.charAt(0) && 
                ch == firstChar.charAt(0)) {
                stack.pop();
                totalPoints += secondPoints;
            } else {
                stack.push(ch);
            }
        }

        return totalPoints;
    }
}