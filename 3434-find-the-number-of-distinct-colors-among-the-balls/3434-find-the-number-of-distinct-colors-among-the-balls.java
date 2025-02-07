class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        
         Map<Integer, Integer> ballColors = new HashMap<>(); // Map of ball -> color
        Set<Integer> distinctColors = new HashSet<>(); // Set of distinct colors
        Map<Integer, Integer> colorFrequency = new HashMap<>(); // Color frequency map

        int n = queries.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            // If the ball already has a color, update color frequency
            if (ballColors.containsKey(ball)) {
                int oldColor = ballColors.get(ball);
                colorFrequency.put(oldColor, colorFrequency.get(oldColor) - 1);
                if (colorFrequency.get(oldColor) == 0) {
                    distinctColors.remove(oldColor);
                }
            }

            // Assign new color
            ballColors.put(ball, color);
            colorFrequency.put(color, colorFrequency.getOrDefault(color, 0) + 1);
            distinctColors.add(color);

            // Store the number of distinct colors after this query
            result[i] = distinctColors.size();
        }

        return result;
    }
}