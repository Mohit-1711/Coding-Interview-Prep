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
    public int amountOfTime(TreeNode root, int start) {
        
        Queue<TreeNode> infectedQ = new LinkedList<>();
        HashMap<TreeNode,TreeNode> markParent = new HashMap<>();
        bfs(infectedQ,markParent,root,start);

        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        visited.put(infectedQ.peek(),true);
        int time = -1;  // So that last BFS level ke baad extra time count na ho, jab saare nodes already infect ho chuke ho.
        while(!infectedQ.isEmpty()){
            int size = infectedQ.size();

            for(int i =0;i<size;i++){
                TreeNode curr = infectedQ.poll();

                if(curr.left!=null && visited.get(curr.left)==null){
                    infectedQ.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    infectedQ.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(markParent.get(curr)!=null && visited.get(markParent.get(curr))==null){
                    infectedQ.offer(markParent.get(curr));
                    visited.put(markParent.get(curr),true);
                    
                }
                
            }time++;
        }
        return time;

    }
    public void bfs(Queue<TreeNode> infectedQ, HashMap<TreeNode,TreeNode>markParent,TreeNode root, int start){
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.val==start){
                    infectedQ.offer(curr);
                }
                if(curr.left!=null){
                    markParent.put(curr.left,curr);
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    markParent.put(curr.right,curr);
                    q.offer(curr.right);
                }
            }
        }
    }
}