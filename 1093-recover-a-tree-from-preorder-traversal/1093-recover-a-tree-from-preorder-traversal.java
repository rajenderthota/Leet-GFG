/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
         Stack<TreeNode> stack = new Stack<>();
        int i = 0, n = traversal.length();

        while (i < n) {
            int depth = 0;
            // Count dashes to determine depth
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            // Extract the node value
            int val = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                val = val * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            TreeNode node = new TreeNode(val);

            // Find the correct parent by adjusting the stack size
            while (stack.size() > depth) {
                stack.pop();
            }

            // Attach the node to the correct parent
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }

            // Push the current node to the stack
            stack.push(node);
        }

        // The root node is the bottom-most node in the stack
        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }
}