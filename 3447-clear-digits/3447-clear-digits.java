class Solution {
    public String clearDigits(String s) {
     
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove the closest non-digit character
                }
            } else {
                stack.push(c); // Store letters in stack
            }
        }

        // Convert stack to string
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}