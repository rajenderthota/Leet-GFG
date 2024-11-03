class Solution {
    public int maxMoves(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] maxMovsAt = new int[rows][cols];
        
        for (int r = 0; r < rows; r++) {
            maxMovsAt[r][0] = 1;
        }

        int maxMovs = 0;
        for (int c = 1; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                int left = (grid[r][c - 1] < grid[r][c] && maxMovsAt[r][c - 1] > 0) 
                           ? maxMovsAt[r][c - 1] + 1 : 0;
                int leftUpD = (r - 1 >= 0 && grid[r - 1][c - 1] < grid[r][c] && maxMovsAt[r - 1][c - 1] > 0) 
                              ? maxMovsAt[r - 1][c - 1] + 1 : 0;
                int leftDownD = (r + 1 < rows && grid[r + 1][c - 1] < grid[r][c] && maxMovsAt[r + 1][c - 1] > 0) 
                                ? maxMovsAt[r + 1][c - 1] + 1 : 0;
                
                maxMovsAt[r][c] = Math.max(left, Math.max(leftUpD, leftDownD));
                maxMovs = Math.max(maxMovs, maxMovsAt[r][c] - 1);
            }
        }

        return maxMovs;
    }
}
