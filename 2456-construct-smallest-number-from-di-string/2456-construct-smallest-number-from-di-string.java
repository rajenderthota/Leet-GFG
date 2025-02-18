class Solution {

//using backtracking
 public String smallestNumber(String pattern) {
        boolean[] used = new boolean[10]; // To track used digits (1-9)
        StringBuilder result = new StringBuilder();
        backtrack(pattern, 0, new StringBuilder(), used, result);
        return result.toString();
    }

    private boolean backtrack(String pattern, int index, StringBuilder current, boolean[] used, StringBuilder result) {
        if (index == pattern.length() + 1) {
            if (result.length() == 0 || current.toString().compareTo(result.toString()) < 0) {
                result.setLength(0);
                result.append(current);
            }
            return true;
        }

        for (int num = 1; num <= 9; num++) {
            if (used[num]) continue;
            if (index == 0 || (pattern.charAt(index - 1) == 'I' && current.charAt(index - 1) - '0' < num) ||
                    (pattern.charAt(index - 1) == 'D' && current.charAt(index - 1) - '0' > num)) {
                
                used[num] = true;
                current.append(num);
                
                if (backtrack(pattern, index + 1, current, used, result)) {
                    return true;
                }
                
                current.deleteCharAt(current.length() - 1);
                used[num] = false;
            }
        }
        return false;
    }


    public String smallestNumber_stack(String pattern) {
         StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i <= pattern.length(); i++) {
            stack.push(i + 1);
            
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        
        return result.toString(); 
    }


    
}