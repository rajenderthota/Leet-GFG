class Solution {

    //using adjacent elements 

    public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    if (n == 0) return 0;

    // Arrays to store left and right boundaries for each bar
    int[] left = new int[n];
    int[] right = new int[n];

    // Compute the left boundary for each bar
    left[0] = -1; // The leftmost bar has no left boundary
    for (int i = 1; i < n; i++) {
        int prev = i - 1;
        while (prev >= 0 && heights[prev] >= heights[i]) {
            prev = left[prev]; // Move left to find a smaller bar
        }
        left[i] = prev;
    }

    // Compute the right boundary for each bar
    right[n - 1] = n; // The rightmost bar has no right boundary
    for (int i = n - 2; i >= 0; i--) {
        int next = i + 1;
        while (next < n && heights[next] >= heights[i]) {
            next = right[next]; // Move right to find a smaller bar
        }
        right[i] = next;
    }

    // Compute the maximum rectangle area for each bar
    int maxArea = 0;
    for (int i = 0; i < n; i++) {
        int width = right[i] - left[i] - 1; // Width of the rectangle
        int area = heights[i] * width; // Area of the rectangle
        maxArea = Math.max(maxArea, area); // Update maximum area
    }

    return maxArea;
}



    //below code uses stack 
    public int largestRectangleArea_stack(int[] heights) {
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