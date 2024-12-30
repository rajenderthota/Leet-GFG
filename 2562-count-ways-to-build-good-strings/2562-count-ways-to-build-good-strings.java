class Solution {

    private static final int MOD = 1000000007; // Define the modulo constant
    private HashMap<Integer, Integer> dp = new HashMap<>(); // Memoization map


     public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1000000007;
        HashMap<Integer, Integer> dp = new HashMap<>(); // Map to store length -> num of strings
        dp.put(0, 1); // Base case: one valid string of length 0

        // Populate the dp map for lengths from 1 to high
        for (int i = 1; i <= high; i++) {
            int countZero = dp.getOrDefault(i - zero, 0);
            int countOne = dp.getOrDefault(i - one, 0);
            dp.put(i, (countZero + countOne) % mod);
        }

        // Sum up the counts for lengths from low to high
        int result = 0;
        for (int i = low; i <= high; i++) {
            result = (result + dp.getOrDefault(i, 0)) % mod;
        }

        return result;
    }
    public int countGoodStrings_dp(int low, int high, int zero, int one) {
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