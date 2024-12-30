class Solution {

    private static final int MOD = 1000000007; // Define the modulo constant
    private HashMap<Integer, Integer> dp = new HashMap<>(); // Memoization map



    public int countGoodStrings(int low, int high, int zero, int one) {
         return dfs(0, low, high, zero, one); // Start the recursion
    }


     private int dfs(int length, int low, int high, int zero, int one) {
        if (length > high) {
            return 0; // Base case: if length exceeds the upper limit
        }

        if (dp.containsKey(length)) {
            return dp.get(length); // Return cached result if available
        }

        // Initialize the count with 1 if length is within the valid range
        int count = (length >= low) ? 1 : 0;

        // Add counts from further recursive calls
        count = (count + dfs(length + zero, low, high, zero, one)) % MOD;
        count = (count + dfs(length + one, low, high, zero, one)) % MOD;

        // Cache the result and return
        dp.put(length, count);
        return count;
    }
}