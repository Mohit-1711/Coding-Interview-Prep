/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> markParent = new HashMap<>();
        parentBFS(root, markParent);
        HashMap<TreeNode,Boolean> visited = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target,true);

        int distance = 0;

        while(!q.isEmpty()){
            int size = q.size();
            if(distance==k)break;
            distance++;
            for(int i =0;i<size;i++){

                TreeNode curr = q.poll();

                if(curr.left!=null && visited.get(curr.left)==null){
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(markParent.get(curr)!=null && visited.get(markParent.get(curr))==null){
                    q.offer(markParent.get(curr));
                    visited.put(markParent.get(curr),true);
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            res.add(curr.val);
        }
        return res;
    }

    public void parentBFS(TreeNode root, HashMap<TreeNode, TreeNode> markParent) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null) {
                    markParent.put(curr.left, curr);
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    markParent.put(curr.right, curr);
                    q.offer(curr.right);
                }
            }
        }
    }
}