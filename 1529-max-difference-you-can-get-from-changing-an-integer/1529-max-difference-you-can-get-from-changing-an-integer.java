class Solution {
    public int maxDiff(int num) {
        String numStr = Integer.toString(num);

        // Find the maximum possible number (a) by replacing a digit with 9
        int maxNum = getMaxNum(numStr);

        // Find the minimum possible number (b) by replacing a digit with 1 or 0 (depending on position)
        int minNum = getMinNum(numStr);

        // Return the absolute difference
        return maxNum - minNum;
    }

    // Helper to maximize the number
    private int getMaxNum(String numStr) {
        // Find the first digit not equal to 9 to replace with 9
        char target = ' ';
        for (char c : numStr.toCharArray()) {
            if (c != '9') {
                target = c;
                break;
            }
        }
        if (target == ' ') return Integer.parseInt(numStr); // Already all 9s
        return Integer.parseInt(numStr.replace(target, '9'));
    }

    // Helper to minimize the number
    private int getMinNum(String numStr) {
        char firstChar = numStr.charAt(0);
        char target = ' ';
        char replaceWith = ' ';

        // If first digit is not 1, we replace it with 1 to avoid leading 0
        if (firstChar != '1') {
            target = firstChar;
            replaceWith = '1';
        } else {
            // Otherwise, find the first digit (not first position) not 0 or 1 and replace with 0
            for (int i = 1; i < numStr.length(); i++) {
                char c = numStr.charAt(i);
                if (c != '0' && c != '1') {
                    target = c;
                    replaceWith = '0';
                    break;
                }
            }
        }

        if (target == ' ') return Integer.parseInt(numStr); // No valid target found
        return Integer.parseInt(numStr.replace(target, replaceWith));
    }
}