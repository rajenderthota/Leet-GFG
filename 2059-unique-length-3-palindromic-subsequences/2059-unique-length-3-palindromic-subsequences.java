class Solution {
    public int countPalindromicSubsequence(String s) {
         int n = s.length();
        int[] left = new int[26];
        int[] right = new int[26];
        
        // Fill the right frequency array
        for (char c : s.toCharArray()) {
            right[c - 'a']++;
        }

        HashSet<String> uniquePalindromes = new HashSet<>();

        // Traverse the string
        for (int i = 0; i < n; i++) {
            char midChar = s.charAt(i);

            // Decrement the count of current character in the right array
            right[midChar - 'a']--;

            // Check for all characters (a-z) as left and right characters
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (left[ch - 'a'] > 0 && right[ch - 'a'] > 0) {
                    // Form the palindrome and add to the set
                    uniquePalindromes.add("" + ch + midChar + ch);
                }
            }

            // Increment the count of the current character in the left array
            left[midChar - 'a']++;
        }

        return uniquePalindromes.size();
    }
}