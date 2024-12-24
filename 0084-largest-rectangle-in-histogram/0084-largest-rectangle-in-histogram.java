class Solution {
    public int largestRectangleArea(int[] heights) {
        // find the lenght of heights
        int n = heights.length, max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int weight = stack.isEmpty() ? i : i - stack.peek() - 1;

                //  System.out.println(stack);
                max = Math.max(max, height * weight);
            }
            stack.push(i);
        }

        System.out.println(stack);
        return max;
    }
}