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

    private int preIndex = 0;
    private Map<Integer, Integer> postIndexMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        
    // Store postorder indexes in a hashmap for quick lookup
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }
        return buildTree(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] postorder, int left, int right) {
        if (left > right || preIndex >= preorder.length) {
            return null;
        }

        // The first element in preorder is always the root
        TreeNode root = new TreeNode(preorder[preIndex++]);

        if (left == right || preIndex >= preorder.length) {
            return root; // Single node tree case
        }

        // Find the index of preorder[preIndex] in postorder to determine the left subtree boundary
        int leftSubtreeIndex = postIndexMap.get(preorder[preIndex]);

        // Recursively construct left and right subtrees
        root.left = buildTree(preorder, postorder, left, leftSubtreeIndex);
        root.right = buildTree(preorder, postorder, leftSubtreeIndex + 1, right - 1);

        return root;
    }

    // Helper function to print tree (Level Order)
    public static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.print(node.val + " ");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                System.out.print("null ");
            }
        }
        System.out.println();
    }
}