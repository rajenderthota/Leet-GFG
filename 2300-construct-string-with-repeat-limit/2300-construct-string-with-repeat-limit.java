class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
         // Frequency array for characters
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Priority Queue to store characters by their frequency in lexicographical order
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer((char) ('a' + i));
            }
        }

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            int currentCount = Math.min(freq[current - 'a'], repeatLimit);

            // Append the current character up to `repeatLimit` times
            for (int i = 0; i < currentCount; i++) {
                result.append(current);
            }
            freq[current - 'a'] -= currentCount;

            // If the character's frequency is still left, we need to insert a different character
            if (freq[current - 'a'] > 0) {
                if (maxHeap.isEmpty()) {
                    break; // No other character to interleave
                }
                char next = maxHeap.poll();
                result.append(next);
                freq[next - 'a']--;

                // Re-add the next character back to the heap if it still has remaining frequency
                if (freq[next - 'a'] > 0) {
                    maxHeap.offer(next);
                }

                // Re-add the current character back to the heap
                maxHeap.offer(current);
            }
        }

        return result.toString();
    }
}