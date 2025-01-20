class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {

        int rows=mat.length;
        int cols=mat[0].length;
        int n=arr.length;
        int visitedRowCount[]=new int[rows];
        int visitedColCount[]=new int[cols];

        HashMap<Integer,Integer[]> matrixMap=new HashMap<>();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                // Integer val[]=new Integer(2);
                matrixMap.put(mat[i][j],new Integer[]{i,j});
            }
        }
        int count=0;
        for(;count<n;count++){

            Integer []xy=matrixMap.get(arr[count]);

            visitedColCount[xy[1]]+=1;
            visitedRowCount[xy[0]]+=1;
            
            if(visitedColCount[xy[1]] == rows){
                break;
            }
            if( visitedRowCount[xy[0]] == cols)
            break;

            // count++;
        }
        
        return count;
    }
}