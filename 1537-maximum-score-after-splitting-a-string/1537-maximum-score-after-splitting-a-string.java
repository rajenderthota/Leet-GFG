class Solution {
    public int maxScore(String s) {
        
       int n = s.length();
        
        // Count total number of '1's in the string
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }
        
        int maxScore = 0;
        int leftZeros = 0;
        int rightOnes = totalOnes;
        
        // Iterate through the string, keeping track of scores
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }
            
            // Calculate score for this split
            int currentScore = leftZeros + rightOnes;
            maxScore = Math.max(maxScore, currentScore);
        }
        
        return maxScore;
    }
}