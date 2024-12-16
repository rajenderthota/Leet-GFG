class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
int n = nums.length;

        // PriorityQueue to store pairs of (value, index), sorted by value then index
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        );

        // Insert all elements with their indices into the priority queue
        for (int i = 0; i < n; i++) {
            minHeap.add(new int[] {nums[i], i}); // Store (value, index)
        }

        // Perform k operations
        for (int i = 0; i < k; i++) {
            // Extract the smallest value and its index
            int[] current = minHeap.poll();
            int value = current[0];
            int index = current[1];

            // Update the value by multiplying it with the multiplier
            value *= multiplier;

            // Update the original array with the new value
            nums[index] = value;

            // Insert the updated pair back into the priority queue
            minHeap.add(new int[] {value, index});
        }

        return nums; // Return the final array state
    }
}