class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0L));

        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            long first = q.peek().position;
            long last = first;

            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                TreeNode node = curr.node;

                long pos = curr.position - first; //normalize, count starts from 0 at each level (since at 3000 node overflow can happen)
                last = pos;

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * pos));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * pos + 1));
                }
            }

            maxWidth = Math.max(maxWidth, (int) (last + 1));
        }

        return maxWidth;
    }
}

class Pair {
    TreeNode node;
    long position;

    Pair(TreeNode node, long position) {
        this.node = node;
        this.position = position;
    }
}