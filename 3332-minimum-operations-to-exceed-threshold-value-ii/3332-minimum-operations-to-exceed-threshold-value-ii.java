class Solution {

    public int minOperations(int[] nums, int k){
            // Create a min-heap using PriorityQueue
        PriorityQueue<Long> minheap = new PriorityQueue<>();
        for (int num : nums) {
            minheap.add((long) num); // Add all elements to the heap
        }

        int count = 0; // Counter for the number of operations
        while (!minheap.isEmpty()) {
            long min1 = minheap.poll(); // Get the smallest element
            if (min1 >= k) {
                break; // If the smallest element is >= k, stop
            }
            long min2 = minheap.poll(); // Get the second smallest element
            // Push the new element into the heap
            minheap.add(2 * Math.min(min1, min2) + Math.max(min1, min2));
            count++; // Increment the operation count
        }
        return count;
    }

    public int minOperations2(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add only elements < k to the heap
        for (int num : nums) {
            if (num < k) {
                minHeap.add(num);
            }
        }

        int operations = 0;
        
        // Process elements until all are >= k
        while (minHeap.size() > 1 && minHeap.peek() < k) {
            // Extract the two smallest elements
            int x = minHeap.poll();
            int y = minHeap.poll();
            
            // Compute the new value
            int newElement = x * 2 + y;
            
            // Insert back if still < k
            if (newElement < k) {
                minHeap.add(newElement);
            }
            
            // Increment operation count
            operations++;
        }
        
        return operations;
    }
    public int minOperations1(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        int countAboveK = 0;
        
        // Add all elements to the heap and count how many are already >= k
        for (int num : nums) {
            if (num >= k) {
                countAboveK++;
            } else {
                minHeap.add(num);
            }
        }

        // If all elements are already >= k, no operations are needed
        if (countAboveK == nums.length) {
            return 0;
        }

        int operations = 0;
        
        // Process elements until all are >= k
        while (!minHeap.isEmpty() && minHeap.peek() < k) {
            // Ensure at least two elements are present
            if (minHeap.size() < 2) {
                break;
            }

            // Extract the two smallest elements
            int x = minHeap.poll();
            int y = minHeap.poll();
            
            // Compute the new value
            int newElement = x * 2 + y;
            
            // Insert back only if it's still < k
            if (newElement < k) {
                minHeap.add(newElement);
            } else {
                countAboveK++;
            }
            
            // Increment operation count
            operations++;
        }
        
        return operations;

    }
}