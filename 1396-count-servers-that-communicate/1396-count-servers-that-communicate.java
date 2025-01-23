class Solution {


//using dfs

public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int totalServers = 0;

        // Traverse the grid to find unvisited servers
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    // Perform DFS to count all connected servers
                    int count = dfs(grid, visited, i, j);
                    // Add to total if more than one server is found in the component
                    if (count > 1) {
                        totalServers += count;
                    }
                }
            }
        }

        return totalServers;
    }

    private int dfs(int[][] grid, boolean[][] visited, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;

        // Mark the current server as visited
        visited[x][y] = true;

        int count = 1; // Count the current server

        // Traverse all servers in the same row
        for (int j = 0; j < n; j++) {
            if (grid[x][j] == 1 && !visited[x][j]) {
                count += dfs(grid, visited, x, j);
            }
        }

        // Traverse all servers in the same column
        for (int i = 0; i < m; i++) {
            if (grid[i][y] == 1 && !visited[i][y]) {
                count += dfs(grid, visited, i, y);
            }
        }

        return count;
    }



//using bfs approach

 public int countServers2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int totalServers = 0;

        // Directions for row and column movement (up, down, left, right)
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // BFS function to traverse connected servers
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int count = bfs(grid, visited, i, j, directions);
                    // Count all servers in this connected component if it's > 1
                    if (count > 1) {
                        totalServers += count;
                    }
                }
            }
        }

        return totalServers;
    }

    private int bfs(int[][] grid, boolean[][] visited, int startX, int startY, int[][] directions) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int serverCount = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            serverCount++;

            // Check all directions
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                // Traverse all connected servers in the same row or column
                while (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    if (grid[newX][newY] == 1 && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX, newY});
                    }

                    // Move in the same row or column (only one coordinate changes)
                    newX += direction[0];
                    newY += direction[1];
                }
            }
        }

        return serverCount;
    }




    public int countServers1(int[][] grid) {
                int m = grid.length;
        int n = grid[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Step 1: Count servers in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        // Step 2: Count servers that can communicate
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    count++;
                }
            }
        }

        return count;
    }
}