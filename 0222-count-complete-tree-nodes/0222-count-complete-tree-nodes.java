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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = getLeftHeight(root);
        int right = getRightHeight(root);

        if(left==right) return ((2<<left)-1); // 2^height -1 = total number of nodes in a complete totally filled BT
        else{
            return countNodes(root.left)+countNodes(root.right)+1; // if height is not same we add curr node 1+ left res + right res
        }
    }
    public int getLeftHeight(TreeNode root){
        int count =0;
        while(root.left!=null){
            count++;
            root= root.left;
        }
        return count;
    }
    public int getRightHeight(TreeNode root){
        int count =0;
        while(root.right!=null){
            count++;
            root= root.right;
        }
        return count;
    }
}