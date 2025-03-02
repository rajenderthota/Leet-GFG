class Solution {



    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        ArrayList<int[]> result=new ArrayList<>();
        int n=nums1.length, m=nums2.length;
        int i=0,j=0;

        while( i< n && j < m){

            if( nums1[i][0] == nums2[j][0]){
                result.add( new int[]{nums1[i][0], nums1[i][1]+nums2[j][1]});
                i++;j++;
            }else if( nums1[i][0] < nums2[j][0]){
                result.add( nums1[i]);
                i++;
            }else{
                // result.add(new int[]{nums2[j][0],nums2[j][1]});
                result.add(nums2[j]);
                j++;
            }
        }

        while(i < n){
            result.add(nums1[i]);
            i++;
        }

        while(j < m){
            result.add(nums2[j]);
            j++;
        }


        return result.toArray(new int[result.size()][]);
    }

    public int[][] mergeArrays1(int[][] nums1, int[][] nums2) {

        // Arrays.sort(nums1,(a,b)->a[0]-b[0]);
        // Arrays.sort(nums2, (a,b)->a[0]-b[0]);
        HashSet<Integer> equalSet=new HashSet<>();
        int n=nums1.length;
        int m=nums2.length;

        for(int i=0;i<n;i++){
            equalSet.add(nums1[i][0]);
        }
          for(int i=0;i<m;i++){
            equalSet.add(nums2[i][0]);
        }
        
        int[][] result=new int[equalSet.size()][2];
        

        int i=0,j=0,k=0;

        while( i < n && j < m){

            if(nums1[i][0] == nums2[j][0]){
                result[k][0]=nums1[i][0];
                result[k][1]=nums1[i][1]+nums2[j][1];
                i++;
                j++;
            }else if( nums1[i][0] < nums2[j][0]){
                result[k][0]=nums1[i][0];
                result[k][1]=nums1[i][1];
                i++;
            }else{
                result[k][0]=nums2[j][0];
                result[k][1]=nums2[j][1];
                j++;
            }
            k++;
        }

        while(i < n){
            result[k][0]=nums1[i][0];
            result[k][1]=nums1[i][1];
            i++;k++;
        }

      while(j < m){
            result[k][0]=nums2[j][0];
            result[k][1]=nums2[j][1];
            j++;k++;
        }



        return result;
        
    }
}