class Solution {
    public int[] applyOperations(int[] nums) {

        int n=nums.length;

        int left=0,right=1;

        while(right < n){

            if( nums[left] == nums[right]){
                nums[left]=2*nums[right];
                nums[right]=0;
            }

            left++;
            right++;
        }
//         int count=0;
//         left=0;right=n-1;
//         for(int i=0;i<n;i++){

//             if(nums[i] != 0){
//                 nums[count]=nums[i];
//                 count++;
//             }else{
//                 if( i != count){
//                     nums[i]=0;
//                 }
//             }
//         }
// System.out.println(count);
//         for(int i=count+1;i<n;i++){
//             nums[i]=0;
//         }

//    count=0;
//         for(int i=0;i<n;i++){
//             if(nums[i] == 0)
//             count++;
//         }

// System.out.println(n);
// System.out.println(n-count);
          
          
//         for(int i=n-count;i<n;i++){
//            nums[i]=0;
//         }

 // Step 2: Shift all zeros to the end in-place
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
        
        return nums;

        
    }
}