class Solution {
    public int maximumLength(String s) {

        //brute force approach
        // int sl=s.length();
        // int count=0;
        // for(int i=0;i<sl;i++){

        //     String substr1=s.substring(0,i);

        //     for(int j=i+1;j<=sl;j++){

        //         String substr2=s.substring(i,j);

        //         for(int k=j+1;k<=sl;k++){

        //             String substr3= s.substring(j,k);

        //             if(substr1.equals(substr2) && substr2.equals(substr3)){
        //                 count++;
        //             }
        //         }
        //     }
        // }

        // return count==0 ? -1:count;

        return longestSpecialSubstring(s);
    }

//solution code from here

 public int longestSpecialSubstring(String s) {
        int n = s.length();
        int maxLen = -1;

        // Iterate over all possible lengths of special substrings
        for (int len = n; len >= 1; len--) {
            if (hasSpecialSubstring(s, len)) {
                return len; // Return the maximum length when found
            }
        }
        return maxLen;
    }

    // Helper function to check if a special substring of length `len` occurs at least 3 times
    private boolean hasSpecialSubstring(String s, int len) {
        int n = s.length();
        Map<String, Integer> freqMap = new HashMap<>();

        // Sliding window over all substrings of length `len`
        for (int i = 0; i <= n - len; i++) {
            String substring = s.substring(i, i + len);

            // Check if the substring is special (all characters are the same)
            if (isSpecial(substring)) {
                freqMap.put(substring, freqMap.getOrDefault(substring, 0) + 1);

                // If a substring occurs at least 3 times, return true
                if (freqMap.get(substring) >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    // Helper function to check if a string is special
    private boolean isSpecial(String str) {
        char firstChar = str.charAt(0);
        for (char c : str.toCharArray()) {
            if (c != firstChar) {
                return false;
            }
        }
        return true;
    }

//end of solution code


}