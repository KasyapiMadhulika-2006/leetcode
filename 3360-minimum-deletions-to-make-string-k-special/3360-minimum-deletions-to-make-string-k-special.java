class Solution {
    public int minimumDeletions(String word, int k) {
       Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Convert frequency values to a list and sort
        List<Integer> freqs = new ArrayList<>(freqMap.values());
        Collections.sort(freqs);

        int n = freqs.size();
        int minDeletions = Integer.MAX_VALUE;

        // Try keeping each frequency as base and adjust others
        for (int i = 0; i < n; i++) {
            int baseFreq = freqs.get(i);
            int deletions = 0;

            // Characters with frequency less than base can stay
            // Characters with frequency > base + k must be reduced
            for (int j = 0; j < n; j++) {
                if (freqs.get(j) < baseFreq) {
                    deletions += freqs.get(j); // Delete all
                } else if (freqs.get(j) > baseFreq + k) {
                    deletions += freqs.get(j) - (baseFreq + k); // Reduce to max allowed
                }
            }

            minDeletions = Math.min(minDeletions, deletions);
        }

        return minDeletions; 
    }
}