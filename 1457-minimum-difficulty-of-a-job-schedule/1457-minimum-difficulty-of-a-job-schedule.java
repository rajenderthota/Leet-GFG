class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
         int n = jobDifficulty.length;

        // If we cannot divide jobs into d days, return -1
        if (d > n) return -1;

        // Initialize DP array with maximum values
        int[][] dp = new int[d + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Base case: No jobs, no difficulty
        dp[0][0] = 0;

        // Iterate over days
        for (int day = 1; day <= d; day++) {
            for (int i = day; i <= n; i++) {
                int maxDifficulty = 0;

                // Iterate over job split points
                for (int j = i; j >= day; j--) {
                    maxDifficulty = Math.max(maxDifficulty, jobDifficulty[j - 1]);
                    if (dp[day - 1][j - 1] != Integer.MAX_VALUE) {
                        dp[day][i] = Math.min(dp[day][i], dp[day - 1][j - 1] + maxDifficulty);
                    }
                }
            }
        }

        // The result is the minimum difficulty for all jobs in d days
        return dp[d][n] == Integer.MAX_VALUE ? -1 : dp[d][n];
    }
}