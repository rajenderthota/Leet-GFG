class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        int max=1;
        int n=nums.length;
        //find longest stricly increasing subarray
        for(int i=0;i<n;i++){
            int current=nums[i],count=0;
             ArrayList<Integer> subArray=new ArrayList<>();
             subArray.add(current);
            for(int j=i+1;j<n;j++){
                if(current < nums[j] ){
                    count++;
                    subArray.add(nums[j]);
                    current=nums[j];
                }else{
                    break;
                }
            }

            max=Math.max(subArray.size(),max);
        }


         for(int i=0;i<n;i++){
            int current=nums[i],count=0;
            ArrayList<Integer> subArray=new ArrayList<>();
            subArray.add(current);
            for(int j=i+1;j<n;j++){
                if(current > nums[j] ){
                    count++;
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