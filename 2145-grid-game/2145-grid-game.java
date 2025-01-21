class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        
        // Calculate prefix and suffix sums
        long[] prefixSum = new long[n];
        long[] suffixSum = new long[n];
        
        // Prefix sum for the top row
        prefixSum[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + grid[0][i];
        }
        
        // Suffix sum for the bottom row
        suffixSum[n - 1] = grid[1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + grid[1][i];
        }
        
        // Minimize the maximum points the second robot can collect
        long result = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // Points left for the second robot if the first robot transitions at column i
            long pointsTop = (i + 1 < n) ? prefixSum[n - 1] - prefixSum[i] : 0; // Top row after i
            long pointsBottom = (i - 1 >= 0) ? suffixSum[0] - suffixSum[i] : 0; // Bottom row before i
            
            long secondRobotPoints = Math.max(pointsTop, pointsBottom);
            result = Math.min(result, secondRobotPoints);
        }
        
        return result;
    }
}