class Solution {
     private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // right, left, down, up

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Priority Queue for Dijkstra's algorithm (cost, row, col)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); // Start with cost 0 at (0, 0)

        // Visited array to track minimum cost for each cell
        int[][] cost = new int[m][n];
        for (int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE);
        cost[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currCost = curr[0], x = curr[1], y = curr[2];

            // If we reach the bottom-right corner, return the cost
            if (x == m - 1 && y == n - 1) return currCost;

            // Try all 4 directions
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + DIRECTIONS[dir][0];
                int ny = y + DIRECTIONS[dir][1];
                int nextCost = currCost + (grid[x][y] == dir + 1 ? 0 : 1);

                // Check bounds and update cost if better path found
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && nextCost < cost[nx][ny]) {
                    cost[nx][ny] = nextCost;
                    pq.offer(new int[]{nextCost, nx, ny});
                }
            }
        }

        return -1; // Should never reach here

    }
}