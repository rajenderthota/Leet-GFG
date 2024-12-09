import java.util.*;

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int qs = queries.length;

        // Define the answer array
        boolean[] ans = new boolean[qs];

        // Edge case: If nums has only one element, all queries return true
        if (n == 1) {
            Arrays.fill(ans, true);
            return ans;
        }

        // Step 1: Precompute "alternating parity" array
        boolean[] alternating = new boolean[n];
        List<Integer> violationIndices = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            alternating[i] = (nums[i - 1] % 2 != nums[i] % 2);
            if (!alternating[i]) {
                violationIndices.add(i); // Store the violation index
            }
        }

        // Step 2: Process each query using binary search
        for (int i = 0; i < qs; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            // If the subarray has only one element, it's automatically "special"
            if (left == right) {
                ans[i] = true;
                continue;
            }

            // Binary search for the first violation within [left + 1, right]
            int firstViolationIndex = binarySearch(violationIndices, left + 1);
            if (firstViolationIndex < violationIndices.size() && violationIndices.get(firstViolationIndex) <= right) {
                ans[i] = false; // There is a violation in the range
            } else {
                ans[i] = true; // No violations in the range
            }
        }

        return ans;
    }

    // Helper method for binary search
    private int binarySearch(List<Integer> arr, int target) {
        int low = 0, high = arr.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low; // Returns the index of the first element >= target
    }
}
