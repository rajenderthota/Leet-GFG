class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
          // Helper function to check if a character is a vowel
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        
        // Precompute prefix sum
        int n = words.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = isVowelString(words[0], vowels) ? 1 : 0;

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + (isVowelString(words[i], vowels) ? 1 : 0);
        }

        // Answer the queries
        int m = queries.length;
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            if (li == 0) {
                result[i] = prefixSum[ri];
            } else {
                result[i] = prefixSum[ri] - prefixSum[li - 1];
            }
        }

        return result;
    }

       // Helper function to check if a word starts and ends with a vowel
    private static boolean isVowelString(String word, Set<Character> vowels) {
        return vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1));
    }
}