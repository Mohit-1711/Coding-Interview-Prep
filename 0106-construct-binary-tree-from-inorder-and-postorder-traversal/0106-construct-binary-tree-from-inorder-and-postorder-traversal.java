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
    HashMap<Integer,Integer> inMap = new HashMap<>();
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length-1;

        for(int i =0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        return builder(postorder,0,inorder.length-1);
    }
    public TreeNode builder(int postorder[],int inStart, int inEnd){
        if(inStart>inEnd) return null;

        int currRootVal = postorder[postIdx];
        postIdx--;

        TreeNode currRoot = new TreeNode(currRootVal);

        int currRootPos = inMap.get(currRootVal);

        
//unlike Q105 here, right tree is build first because postorder is left-right-root and we are traversing from the end for root at each level
        currRoot.right = builder(postorder,currRootPos+1,inEnd); 
        currRoot.left = builder(postorder,inStart,currRootPos-1);

        return currRoot;
    }
}