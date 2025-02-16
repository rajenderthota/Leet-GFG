class Solution {
       public static int[] constructDistancedSequence(int n) {
        int len = 2 * n - 1;
        int[] result = new int[len]; // Stores the final sequence
        boolean[] used = new boolean[n + 1]; // Tracks which numbers are used

        Arrays.fill(result, 0); // Initialize result with 0s
        backtrack(result, used, n, 0);
        return result;
    }

    private static boolean backtrack(int[] result, boolean[] used, int n, int index) {
        if (index == result.length) {
            return true; // Successfully filled all positions
        }

        // If already filled, move to the next index
        if (result[index] != 0) {
            return backtrack(result, used, n, index + 1);
        }

        // Try placing numbers from largest to smallest
        for (int num = n; num >= 1; num--) {
            if (used[num]) continue; // Skip if already used

            // Positioning constraints
            int secondIndex = (num == 1) ? index : index + num;
            if (secondIndex < result.length && result[secondIndex] == 0) {
                // Place the number
                result[index] = num;
                if (num != 1) result[secondIndex] = num;
                used[num] = true;

                // Recursive call
                if (backtrack(result, used, n, index + 1)) {
                    return true;
                }

                // Backtrack if the placement didn't lead to a solution
                result[index] = 0;
                if (num != 1) result[secondIndex] = 0;
                used[num] = false;
            }
        }
        return false;
    }


}