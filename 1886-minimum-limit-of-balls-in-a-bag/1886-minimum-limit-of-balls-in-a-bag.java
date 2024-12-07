class Solution {
    public int minimumSize(int[] nums, int maxOperations) {

        int left=1,right=0;

        for(int num:nums){
            right=Math.max(right,num);
        }

        int result=right;

        while(left <= right){
            int mid=left+(right-left)/2;
              if (canDivide(nums, maxOperations, mid)) {
                result = mid; // Try to minimize penalty
                right = mid - 1;
            } else {
                left = mid + 1; // Increase penalty to make it feasible
            }
        }

        return result;
        
    }


    //helper function to get given 
    private boolean canDivide(int nums[],int maxOperations, int penalty){
      int operations = 0;

        for (int num : nums) {
            // Calculate required operations for this bag
            if (num > penalty) {
                operations += (num - 1) / penalty; // Number of splits required
            }

            // If operations exceed maxOperations, return false early
            if (operations > maxOperations) {
                return false;
            }
        }

        return true;
    }
}