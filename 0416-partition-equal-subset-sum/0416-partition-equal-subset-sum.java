class Solution {
     public  boolean subset(int arr[],int sum){
        boolean dp[][] = new boolean[arr.length+1][sum+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = true;
        }
        for(int j=1;j<dp[0].length;j++){
            dp[0][j] = false;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }
    
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int i:nums){
            sum +=i;
        }
        if(sum%2 !=0){
            return false;
        }
        return subset(nums,sum/2);
    }
}