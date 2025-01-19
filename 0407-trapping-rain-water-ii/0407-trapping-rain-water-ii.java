class Solution {
    public int trapRainWater(int[][] heightMap) {
         if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;

        // Min-heap to store cells with their heights
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

        // Visited matrix
        boolean[][] visited = new boolean[m][n];

        // Add all boundary cells to the heap
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        int trappedWater = 0;
        int[] directions = {-1, 0, 1, 0, -1}; // For traversing 4 neighbors (up, right, down, left)

        // Process cells from the priority queue
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();

            // Check all 4 neighbors
            for (int k = 0; k < 4; k++) {
                int x = cell.row + directions[k];
                int y = cell.col + directions[k + 1];

                // Skip invalid or visited cells
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                    continue;
                }

                // Calculate water trapped
                trappedWater += Math.max(0, cell.height - heightMap[x][y]);

                // Add neighbor to the heap with updated height
                pq.offer(new Cell(x, y, Math.max(cell.height, heightMap[x][y])));
                visited[x][y] = true;
            }
        }

        return trappedWater;
    }


     // Helper class to represent a cell in the grid
    static class Cell {
        int row, col, height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}