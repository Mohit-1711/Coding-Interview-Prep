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
 class BstIterator {
    private Stack<TreeNode> st = new Stack<>();
    boolean reverse;

    public BstIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public TreeNode next() {
        TreeNode temp = st.pop();

        if (!reverse) pushAll(temp.right);
        else pushAll(temp.left);

        return temp;
    }

    public void pushAll(TreeNode node) {
        while (node != null) {
            st.push(node);

            if (reverse) node = node.right;
            else node = node.left;
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        BstIterator l = new BstIterator(root, false);
        BstIterator r = new BstIterator(root, true);

        TreeNode left = l.next();
        TreeNode right = r.next();

        while (left != right) {
            int sum = left.val + right.val;

            if (sum == k) return true;

            if (sum < k) {
                if (!l.hasNext()) return false;
                left = l.next();
            } else {
                if (!r.hasNext()) return false;
                right = r.next();
            }
        }

        return false;
    }
}