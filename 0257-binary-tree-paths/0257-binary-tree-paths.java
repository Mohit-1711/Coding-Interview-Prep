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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(root,sb,res);
        return res;
    }
    public void dfs(TreeNode root, StringBuilder sb, List<String>res){
        if(root==null){
            return;
        }
        int currentLength = sb.length();

        if(currentLength>0){
            sb.append("->");
        }
        sb.append(root.val);
        
        if(root.left==null && root.right==null){
            res.add(sb.toString());   
        }
        else{
            dfs(root.left,sb,res);
            dfs(root.right,sb,res);
        }
        sb.setLength(currentLength);
        
        
        
    }
}