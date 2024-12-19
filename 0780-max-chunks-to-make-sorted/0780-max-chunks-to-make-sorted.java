class Solution {
    public int maxChunksToSorted(int[] arr) {
          int chunks = 0; // Initialize chunk counter
        int max = 0; // Tracks the maximum value seen so far
        
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]); // Update the maximum value
            
            // If the maximum value matches the current index, we can make a chunk
            if (max == i) {
                chunks++;
            }
        }
        
        return chunks; // Return the total number of chunks
    }
}