class Solution {

    private boolean bfs(int start, int[] color, int[][] graph) {

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()) {

            int node = q.poll();

            for(int pt : graph[node]) {

                if(color[pt] == -1) {
                    color[pt] = 1 - color[node];
                    q.offer(pt);
                }
                else if(color[pt] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i = 0; i < n; i++) {

            if(color[i] == -1) {
                color[i]=0;
                if(bfs(i, color, graph)==false) {
                    return false;
                }
            }
        }

        return true;
    }
}