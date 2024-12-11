class MinStack {

   private Stack<Integer> stack;
    private Stack<Integer> minStack;

    // Constructor
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push operation
    public void push(int val) {
        stack.push(val);
        // Push to minStack if it's empty or the new value is less than or equal to the current minimum
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // Pop operation
    public void pop() {
        // If the top of both stacks are the same, pop from minStack as well
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    // Top operation
    public int top() {
        return stack.peek();
    }

    // Get minimum element
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */