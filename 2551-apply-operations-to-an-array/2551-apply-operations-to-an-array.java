class Solution {

    //using two point approach

       public static int[] applyOperations(int[] nums) {
        int n = nums.length;
        
        // Step 1: Apply the operations in sequence
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        
        // Step 2: Two-pointer approach to shift non-zero elements forward
        int left = 0; // Pointer to place the next non-zero element
        for (int right = 0; right < n; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
        
        return nums;
    }


// little optimation

 public int[] applyOperations2(int[] nums) {

    int n=nums.length,count=0;

    for( int i=0;i<n-1;i++){

        if( nums[i] == nums[i+1]){
            nums[i]=2*nums[i+1];
            nums[i+1]=0;
        }
    }

    for(int i=0;i<n;i++){

        if( nums[i] != 0){
            nums[count]=nums[i];
            count++;
        }
    }

       // Fill the remaining elements with zero
        while (count < n) {
            nums[count++] = 0;
        }

    return nums;

 }




    public int[] applyOperations1(int[] nums) {

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