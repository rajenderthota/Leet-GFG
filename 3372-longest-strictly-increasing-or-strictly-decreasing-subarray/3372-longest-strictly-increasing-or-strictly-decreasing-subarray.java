class Solution {


public int longestMonotonicSubarray(int[] nums) {

    int count=1;
    int inc=1,dec=1;
    int n=nums.length;
    for( int i=1;i<n;i++){

        if( nums[i] > nums[i-1]){
            inc++;
            dec=1;
        }else if(nums[i] < nums[i-1]){
            inc=1;
            dec++;
        }else{
            inc=1;
            dec=1;
        }

        count=Math.max(count,Math.max(inc, dec));
    }

    return count;
}

    //below bruteforce approach
    public int longestMonotonicSubarray_bruteforce(int[] nums) {

        int max=1;
        int n=nums.length;
        //find longest stricly increasing subarray
        for(int i=0;i<n;i++){
            int current=nums[i];
             ArrayList<Integer> subArray=new ArrayList<>();
             subArray.add(current);
            for(int j=i+1;j<n;j++){
                if(current < nums[j] ){
                    subArray.add(nums[j]);
                    current=nums[j];
                }else{
                    break;
                }
            }

            max=Math.max(subArray.size(),max);
        }


         for(int i=0;i<n;i++){
            int current=nums[i];
            ArrayList<Integer> subArray=new ArrayList<>();
            subArray.add(current);
            for(int j=i+1;j<n;j++){
                if(current > nums[j] ){
                    subArray.add(nums[j]);
                    current=nums[j];
                }else{
                    break;
                }
            }

            max=Math.max(subArray.size(),max);
        }

        return max;
    }


    //     public static void generateSubarrays(int[] arr) {
    //     for (int start = 0; start < arr.length; start++) {
    //         for (int end = start; end < arr.length; end++) {
    //             int[] subarray = Arrays.copyOfRange(arr, start, end + 1);
    //             System.out.println(Arrays.toString(subarray));
    //         }
    //     }
    // }
}