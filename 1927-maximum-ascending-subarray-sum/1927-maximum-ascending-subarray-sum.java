class Solution {
    public int maxAscendingSum(int[] nums) {

        //monotonic stack example

        int n=nums.length;
        int maxSum=nums[0];
        int currentSum=nums[0];
        for(int i=1;i<n;i++){

            if(nums[i] > nums[i-1]){
                currentSum+=nums[i];
            }else{
                currentSum=nums[i];
            }

            maxSum=Math.max(currentSum,maxSum);

        }

        return maxSum;
        
    }
}