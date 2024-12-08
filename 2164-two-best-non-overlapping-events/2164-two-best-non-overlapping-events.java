class Solution {

//using dp code starts from here


 public int maxTwoEvents(int[][] events) {
        // Step 1: Sort events by their end time
        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        int n = events.length;
        int[] dp = new int[n];
        int[] maxValue = new int[n]; // Max value considering all events up to this point

        // Step 2: Initialize dp and maxValue arrays
        dp[0] = events[0][2];
        maxValue[0] = events[0][2];

        for (int i = 1; i < n; i++) {
            // Find the maximum value we can get by picking this event + the best non-overlapping event
            int includeValue = events[i][2];
            int idx = findLastNonOverlapping(events, i);
            if (idx != -1) {
                includeValue += maxValue[idx];
            }
            
            // Update dp and maxValue
            dp[i] = Math.max(dp[i - 1], includeValue);
            maxValue[i] = Math.max(maxValue[i - 1], events[i][2]);
        }

        return dp[n - 1];
    }

    // Binary search to find the last event that ends before the current event starts
    private int findLastNonOverlapping(int[][] events, int currentIndex) {
        int low = 0, high = currentIndex - 1;
        int target = events[currentIndex][0];
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (events[mid][1] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return high; // Return the index of the last non-overlapping event
    }



//using dp ends here



    public int maxTwoEvents_regular_approach(int[][] events) {
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