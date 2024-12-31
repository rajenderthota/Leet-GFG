class Solution {
    public int mincostTickets(int[] days, int[] costs) {
         // Last travel day
        int lastDay = days[days.length - 1];

        // Create a DP array for days from 1 to lastDay
        int[] dp = new int[lastDay + 1];
        HashSet<Integer> travelDays = new HashSet<>();
        
        // Add travel days to the HashSet for quick lookup
        for (int day : days) {
            travelDays.add(day);
        }

        // Iterate through each day
        for (int i = 1; i <= lastDay; i++) {
            if (!travelDays.contains(i)) {
                // If not traveling this day, cost is the same as the previous day
                dp[i] = dp[i - 1];
            } else {
                // Calculate the cost for each ticket option
                int oneDayPass = dp[i - 1] + costs[0];
                int sevenDayPass = dp[Math.max(0, i - 7)] + costs[1];
                int thirtyDayPass = dp[Math.max(0, i - 30)] + costs[2];

                // Take the minimum cost
                dp[i] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
            }
        }

        return dp[lastDay];
    }
}