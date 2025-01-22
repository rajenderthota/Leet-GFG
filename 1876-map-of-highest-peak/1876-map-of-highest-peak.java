class Solution {
    public int[][] highestPeak(int[][] isWater) {

         int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        for (int[] row : height) {
            Arrays.fill(row, -1); // Initialize heights to -1 (unvisited)
        }

        Queue<int[]> queue = new LinkedList<>();

        // Add all water cells to the queue and set their height to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    height[i][j] = 0;
                }
            }
        }

        // Directions for moving north, east, south, west
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // BFS to assign heights
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currentHeight = height[cell[0]][cell[1]];

            for (int[] dir : directions) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];

                // Check if the new cell is within bounds and unvisited
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && height[newRow][newCol] == -1) {
                    height[newRow][newCol] = currentHeight + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return height;
        
    }
}