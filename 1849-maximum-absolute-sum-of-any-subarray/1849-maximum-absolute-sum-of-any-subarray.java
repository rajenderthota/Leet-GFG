class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0, currMax = 0, currMin = 0;
        
        for (int num : nums) {
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);
            
            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
        }
        
        return Math.max(maxSum, Math.abs(minSum));
    }
}