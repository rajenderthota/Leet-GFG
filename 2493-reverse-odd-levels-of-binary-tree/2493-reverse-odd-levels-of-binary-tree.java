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
    public TreeNode reverseOddLevels(TreeNode root) {

       if (root == null) return null;

        // Queue for level-order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean isOddLevel = false; // Track if the current level is odd

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> currentLevelNodes = new ArrayList<>();

            // Collect all nodes in the current level
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelNodes.add(currentNode);

                // Add children to the queue
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }

            // Reverse values if it's an odd level
            if (isOddLevel) {
                int left = 0, right = currentLevelNodes.size() - 1;
                while (left < right) {
                    // Swap node values
                    int temp = currentLevelNodes.get(left).val;
                    currentLevelNodes.get(left).val = currentLevelNodes.get(right).val;
                    currentLevelNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            // Toggle the level indicator
            isOddLevel = !isOddLevel;
        }

        return root;
    }
}