class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Step 1: Sort intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Use a list to collect merged intervals
        List<int[]> merged = new ArrayList<>();

        // Step 3: Iterate through intervals and merge if overlapping
        int[] current = intervals[0];
        merged.add(current);

        for (int[] interval : intervals) {
            int currentEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                // Overlap, merge
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, move to next
                current = interval;
                merged.add(current);
            }
        }

        // Convert list to array
        return merged.toArray(new int[merged.size()][]);
    }
}
    
