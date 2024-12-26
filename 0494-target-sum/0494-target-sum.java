class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
         // Using a HashMap to store computed results (memoization)
        return backtrack(nums, 0, 0, target, new HashMap<>());
    }


    private int backtrack(int[] nums, int index, int currentSum, int target, Map<String, Integer> memo) {
        // Base case: if we've processed all numbers
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        // Memoization key
        String key = index + "," + currentSum;

        // Check if result is already computed
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Recursive calls: add and subtract the current number
        int add = backtrack(nums, index + 1, currentSum + nums[index], target, memo);
        int subtract = backtrack(nums, index + 1, currentSum - nums[index], target, memo);

        // Store the result in the memoization map
        memo.put(key, add + subtract);

        return add + subtract;
    }
}