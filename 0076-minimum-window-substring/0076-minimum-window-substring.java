class Solution {
    public String minWindow(String s, String t) {

         if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        // Frequency map to count characters in t
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        // Sliding window frequency map
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int required = mapT.size();  // Number of distinct characters in t
        int formed = 0;  // Number of distinct characters in the current window that match t's frequency
        
        int left = 0, right = 0;
        int[] ans = {-1, 0, 0};  // Format: [window length, left, right]

        // Sliding window
        while (right < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // Check if the current character's frequency matches the one in t
            if (mapT.containsKey(c) && windowMap.get(c).intValue() == mapT.get(c).intValue()) {
                formed++;
            }

            // Try to contract the window until it is no longer valid
            while (left <= right && formed == required) {
                // Update the result if this window is smaller than the previous smallest window
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // Remove one character from the left of the window
                char lChar = s.charAt(left);
                windowMap.put(lChar, windowMap.get(lChar) - 1);

                // If the removed character is part of t and its frequency in the window is less than required, update formed
                if (mapT.containsKey(lChar) && windowMap.get(lChar).intValue() < mapT.get(lChar).intValue()) {
                    formed--;
                }

                left++;
            }

            // Expand the window
            right++;
        }

        // Return the smallest window or an empty string if no valid window was found
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);

    }
}