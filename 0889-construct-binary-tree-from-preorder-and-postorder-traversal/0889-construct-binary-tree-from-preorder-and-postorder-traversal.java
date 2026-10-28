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
    int preIndex = 0;
    HashMap<Integer, Integer> postMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }

        return build(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] postorder,
                           int left, int right) {
        if (left > right || preIndex >= preorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex++]);

        if (left == right) {
            return root;
        }

        // Next preorder element is the left child's root
        int leftRoot = preorder[preIndex];

        // Find the left subtree's ending position in postorder
        int mid = postMap.get(leftRoot);

        root.left = build(preorder, postorder, left, mid);

        root.right = build(preorder, postorder, mid + 1, right - 1);

        return root;
    }
}
