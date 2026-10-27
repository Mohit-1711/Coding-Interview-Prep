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
    HashMap<Integer,Integer> inOrderMapVsIndex = new HashMap<>();
    int preIndex =0; 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i =0;i<inorder.length;i++){
            inOrderMapVsIndex.put(inorder[i],i);
        }
        return builder(preorder,0,inorder.length-1);
    }
    public TreeNode builder(int[] preorder,int inStart, int inEnd){
        if(inStart>inEnd) return null;

        int rootVal = preorder[preIndex];
        preIndex++;

        TreeNode currRoot = new TreeNode(rootVal);

        int currRootIdx = inOrderMapVsIndex.get(rootVal);

        currRoot.left = builder(preorder,inStart, currRootIdx-1); // building left side of the tree first 
        currRoot.right = builder(preorder,currRootIdx+1, inEnd); // then right side

        return currRoot;
    }
}