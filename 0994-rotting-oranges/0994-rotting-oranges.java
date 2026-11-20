class Pair {
    int i;
    int j;
    int time;

    Pair(int i, int j, int time) {
        this.i = i;
        this.j = j;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new ArrayDeque<>();

        int visited[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = 2;
                    q.offer(new Pair(i, j, 0));
                } else {
                    visited[i][j] = 0;
                }
            }
        }
        int res =0;
        while (!q.isEmpty()) {
            int size = q.size();
            int freshTime =0;
            for (int x = 0; x < size; x++) {
                Pair curr = q.poll();
                int i = curr.i;
                int j = curr.j;
                int time = curr.time;

                res = time;
                freshTime = time+1;
                

                //Up
                if (i - 1 >= 0 && grid[i - 1][j] == 1 && visited[i-1][j]==0) {
                    visited[i-1][j] = 2;
                    q.offer(new Pair(i-1,j,freshTime));
                }
                //down
                if (i + 1 < n && grid[i + 1][j] == 1 && visited[i+1][j]==0) {
                    visited[i+1][j] = 2;
                    q.offer(new Pair(i+1,j,freshTime));
                }
                //left
                if (j - 1 >= 0 && grid[i][j-1] == 1 && visited[i][j-1]==0) {
                    visited[i][j-1] = 2;
                    q.offer(new Pair(i,j-1,freshTime));
                }
                //right
                
                if (j + 1 < m && grid[i][j+1] == 1 && visited[i][j+1]==0) {
                    visited[i][j+1] = 2;
                    q.offer(new Pair(i,j+1,freshTime));
                }
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j]==0 && grid[i][j]==1){
                    return -1;
                }
            }
        }
        return res;
    }
}