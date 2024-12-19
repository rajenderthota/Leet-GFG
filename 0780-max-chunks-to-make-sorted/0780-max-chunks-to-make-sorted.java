class Solution {


        //below solution uses time complexity o(n) and space complexity o(n) :: stack implementation
    public int maxChunksToSorted(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            // If the stack is empty or the current number is greater than the stack's top
            if (stack.isEmpty() || num >= stack.peek()) {
                stack.push(num);
            } else {
                // Merge chunks: keep the max value of the chunk
                int maxInChunk = stack.pop();
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.pop();
                }
                stack.push(maxInChunk);
            }
        }

        // The size of the stack represents the number of chunks
        return stack.size();
    }

    


    //below solution uses time complexity o(n) and space complexity o(1)
    public int maxChunksToSorted1(int[] arr) {
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