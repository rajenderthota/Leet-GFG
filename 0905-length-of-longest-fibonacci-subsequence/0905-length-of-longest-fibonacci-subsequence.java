class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[][] dp = new int[n][n];
        int maxLength = 0;

        // Store indices of elements for quick lookup
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        // Iterate through all pairs (j, i) with j < i
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int prev = arr[i] - arr[j]; // Expected previous Fibonacci number
                if (prev < arr[j] && indexMap.containsKey(prev)) {
                    int k = indexMap.get(prev);
                    dp[j][i] = dp[k][j] + 1;
                } else {
                    dp[j][i] = 2; // Default value for a new sequence
                }
                maxLength = Math.max(maxLength, dp[j][i]);
            }
        }

        return maxLength > 2 ? maxLength : 0; // Return 0 if no valid sequence found
    
    }
}