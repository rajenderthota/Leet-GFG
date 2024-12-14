class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int left = 0; // Left pointer of the sliding window
        Deque<Integer> maxDeque = new LinkedList<>(); // To maintain maximum elements
        Deque<Integer> minDeque = new LinkedList<>(); // To maintain minimum elements
        long count = 0; // To store the total count of valid subarrays

        for (int right = 0; right < n; right++) {
            // Maintain the maxDeque
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // Maintain the minDeque
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // Shrink the window if the condition is violated
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > 2) {
                left++;
                // Remove out-of-bound indices
                if (maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
            }

            // Count all subarrays ending at 'right'
            count += (right - left + 1);
        }

        return count;
    }
}