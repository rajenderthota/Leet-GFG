class Solution {
    public boolean canConstruct(String s, int k) {

        if (k > s.length()) {
            // If k is greater than the total number of characters, it's impossible
            return false;
        }

        // Count the frequency of each character
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Count the number of characters with odd frequency
        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // We can form at most `s.length()` palindromes and need at least `oddCount` palindromes
        return oddCount <= k;
    }
}