class Solution {
    public int maxTwoEvents(int[][] events) {
        // Sort the events by their end times
        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        // Array to keep the maximum value till the current event
        int n = events.length;
        int[] maxVal = new int[n];
        
        // Track the maximum value we can have from just one event
        maxVal[0] = events[0][2];
        for (int i = 1; i < n; i++) {
            maxVal[i] = Math.max(maxVal[i - 1], events[i][2]);
        }

      

        // Result to track the maximum sum of two events
        int result = 0;

        // Iterate over each event and try to find the best pairing
        for (int i = 0; i < n; i++) {
            // Option 1: Take the current event alone
            result = Math.max(result, events[i][2]);

            // Option 2: Pair the current event with the best earlier non-overlapping event
            int idx = findNonOverlapping(events, events[i][0], 0, i - 1);
            if (idx != -1) {
                result = Math.max(result, events[i][2] + maxVal[idx]);
            }
        }

        return result;
    }


      // Function to perform binary search for the largest event that ends before the given start time
        int findNonOverlapping(int[][] events, int start, int low, int high) {
            int res = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (events[mid][1] < start) {
                    res = mid; // Found a valid event, move to the right to find the largest possible
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return res;
        }
}