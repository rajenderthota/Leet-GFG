class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
         int n = nums.length;
        int qs = queries.length;

        // Define the answer array
        boolean[] ans = new boolean[qs];

        // Edge case: If nums has only one element, all queries return true
        if (n == 1) {
            for (int i = 0; i < qs; i++) {
                ans[i] = true;
            }
            return ans;
        }

        // Step 1: Precompute an "alternating parity" prefix array
        boolean[] alternating = new boolean[n];
        for (int i = 1; i < n; i++) {
            alternating[i] = (nums[i - 1] % 2 != nums[i] % 2);
        }

        // Step 2: Create a prefix sum array of the "alternating" array
        int[] prefixSum = new int[n];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + (alternating[i] ? 1 : 0);
        }

        // Step 3: Process each query using the prefix sum array
        for (int i = 0; i < qs; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            // If the subarray has only one element, it's automatically "special"
            if (left == right) {
                ans[i] = true;
                continue;
            }

            // Check if all adjacent elements in the range alternate in parity
            ans[i] = (prefixSum[right] - prefixSum[left] == (right - left));
        }

        return ans;

    }
}