class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols]; // DP table to store max square length
        int maxSide = 0; // Stores the max square side length

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') { // Only process '1' cells
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1; // First row or first column
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]); // Update max square side
                }
            }
        }
        return maxSide * maxSide; // Return the area of the largest square
    
    }
}