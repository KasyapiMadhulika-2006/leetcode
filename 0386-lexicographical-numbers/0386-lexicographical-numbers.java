class Solution {
    public List<Integer> lexicalOrder(int n) {
       List<Integer> result = new ArrayList<>(n);
        int curr = 1;

        for (int i = 1; i <= n; i++) {
            result.add(curr);

            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                if (curr >= n) {
                    curr /= 10;
                }
                curr++;
                while (curr % 10 == 0) {
                    curr /= 10;
                }
            }
        }

        return result;  
    }
}