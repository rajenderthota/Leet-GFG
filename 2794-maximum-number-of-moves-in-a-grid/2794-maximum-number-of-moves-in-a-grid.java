class Solution {
    public int maxMoves(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];

        // Start from the last column and work backwards
        for (int c = columns - 2; c >= 0; c--) {
            for (int r = 0; r < rows; r++) {
                int maxMovesFromHere = 0;

                // Check the top-right move
                if (r > 0 && grid[r][c] < grid[r - 1][c + 1]) {
                    maxMovesFromHere = Math.max(maxMovesFromHere, 1 + dp[r - 1][c + 1]);
                }

                // Check the right move
                if (grid[r][c] < grid[r][c + 1]) {
                    maxMovesFromHere = Math.max(maxMovesFromHere, 1 + dp[r][c + 1]);
                }

                // Check the bottom-right move
                if (r < rows - 1 && grid[r][c] < grid[r + 1][c + 1]) {
                    maxMovesFromHere = Math.max(maxMovesFromHere, 1 + dp[r + 1][c + 1]);
                }

                dp[r][c] = maxMovesFromHere;
            }
        }

        // Find the maximum moves starting from any cell in the first column
        int maxMoves = 0;
        for (int r = 0; r < rows; r++) {
            maxMoves = Math.max(maxMoves, dp[r][0]);
        }

        return maxMoves;
    }
}
