class Solution {


public static void reverse(int nums[],int left,int right){

    while(left <= right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
        left++;
        right--;
    }


}


    public void rotate(int[] nums, int k) {


        k=k%nums.length;
        // if(nums.length < k)
        // return;
       

       //reverse entire array
       reverse(nums,0,nums.length-1);

       //reverse k elements
       reverse(nums,0,k-1);

       // reverse n-k elements
       reverse(nums,k,nums.length-1);
       
        
        
    }
}