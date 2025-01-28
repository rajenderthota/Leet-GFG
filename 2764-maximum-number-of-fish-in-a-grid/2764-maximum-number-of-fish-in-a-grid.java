class Solution {


      public int findMaxFish(int[][] grid) {


     int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxFish = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    maxFish = Math.max(maxFish, dfs(grid, visited, i, j));
                }
            }
        }

        return maxFish;
    }

    private int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }

        visited[r][c] = true; // Mark the cell as visited
        int fishCount = grid[r][c];

        // Explore all 4 adjacent cells
        fishCount += dfs(grid, visited, r + 1, c);
        fishCount += dfs(grid, visited, r - 1, c);
        fishCount += dfs(grid, visited, r, c + 1);
        fishCount += dfs(grid, visited, r, c - 1);

        return fishCount;
    }


    public int findMaxFish1(int[][] grid) {

        int rows=grid.length;
        int cols=grid[0].length;

        // row prefix sum
        int rowPrefix[][]=new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                // if(j == 0 && i == 0){
                    if(j == 0 ){
                  rowPrefix[i][j]=grid[i][j];
                  continue;  
                }
                if(grid[i][j] > 0){
                    if( j ==1 ){
                       rowPrefix[i][j]+=grid[0][0]; 
                    }
                    rowPrefix[i][j]+=grid[i][j-1]+grid[i][j];
                }
            }
        }


        //column prefix sum
        int colPrefix[][]=new int[rows][cols];

          for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                if(j == 0 || i ==0){
                   colPrefix[j][i]=grid[j][i];
                   continue; 
                }
                if(grid[i][j] > 0){
                    colPrefix[i][j]+=grid[j-1][i]+grid[j][i];
                }
            }
        }


        //find max of row and column prefix sum
        int result=0;

         for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                
                int currentMax=Math.max(colPrefix[j][i],rowPrefix[j][i]);
                result=Math.max(result,currentMax);
            }
        }

        // return result
        
        return result;
    }
}