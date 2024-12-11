class Solution {
    public int maximumBeauty(int[] nums, int k) {
          // Sort the array to enable efficient range operations
        Arrays.sort(nums);

        // Use a sliding window approach to maximize the beauty
        int maxBeauty = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            // Maintain the sliding window condition: nums[end] - nums[start] <= 2 * k
            while (nums[end] - nums[start] > 2 * k) {
                start++;
            }

            // Calculate the beauty for the current window
            maxBeauty = Math.max(maxBeauty, end - start + 1);
        }

        return maxBeauty;
    }
}