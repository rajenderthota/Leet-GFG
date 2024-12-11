class Solution {


 public int maximumBeauty_exceedsTime(int []nums, int k){

    // Use a HashMap to count occurrences of each adjusted value
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxBeauty = 0;

        for (int num : nums) {
            // Adjust the number to fit within the range [num - k, num + k]
            for (int i = num - k; i <= num + k; i++) {
                countMap.put(i, countMap.getOrDefault(i, 0) + 1);
                maxBeauty = Math.max(maxBeauty, countMap.get(i));
            }
        }

        return maxBeauty;
}


    public int maximumBeauty(int []flowers, int additions){

          // Calculate the maximum value after all possible additions.

        // We add extra space for fluctuations in the count within the k range.

        int maxValue = Arrays.stream(flowers).max().getAsInt() + additions * 2 + 2;

        int[] delta = new int[maxValue];

      

        // Build the difference array using the number of additions possible adding and subtracting at the range ends.

        for (int flower : flowers) {

            delta[flower]++;

            delta[flower + additions * 2 + 1]--;

        }

      

        int maxBeauty = 0; // This will hold the maximum beauty calculated so far.

        int runningSum = 0; // This will be used to compute the running sum from the difference array.

      

        // Compute the running sum and find the maximum value.

        for (int value : delta) {

            runningSum += value;

            maxBeauty = Math.max(maxBeauty, runningSum);

        }

      

        // Return the computed maximum beauty of the bouquet.

        return maxBeauty;
    }


    public int maximumBeauty_simple(int[] nums, int k) {
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