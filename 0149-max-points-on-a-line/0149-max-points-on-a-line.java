class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            Map<Double, Integer> map = new HashMap<>();
            int vertical = 0;
            int same = 0;
            int currentMax = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (points[j][0] == points[i][0] && points[j][1] == points[i][1]) {
                    same++;
                } else if (points[j][0] == points[i][0]) {
                    vertical++;
                } else {
                    double slope = (double)(points[j][1] - points[i][1]) / (points[j][0] - points[i][0]);
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                    currentMax = Math.max(currentMax, map.get(slope));
                }
            }

            currentMax = Math.max(currentMax, vertical);
            result = Math.max(result, currentMax + same + 1);
        }
        return result;
    }
}