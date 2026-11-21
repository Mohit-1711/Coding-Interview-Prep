
class Pair {
    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = new int[n][m];
        int[][] vis = new int[n][m];

        Queue<Pair> q = new ArrayDeque<>();

        // Insert all zeroes into the queue REVERSE ENGINEERING instead of making the 1 search for 0, now 0 searh for 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    q.offer(new Pair(i, j));
                    vis[i][j] = 1;
                    ans[i][j] = 0;
                }
            }
        }

        // Multi-source BFS
        while (!q.isEmpty()) {

            Pair p = q.poll();

            int i = p.i;
            int j = p.j;

            // Up
            if (i - 1 >= 0 && vis[i-1][j] == 0) {
                vis[i-1][j] = 1;
                ans[i-1][j] = ans[i][j] + 1; //updating distance at the answer co-ordinates
                q.offer(new Pair(i-1, j));
            }

            // Down
            if (i + 1 < n && vis[i+1][j] == 0) {
                vis[i+1][j] = 1;
                ans[i+1][j] = ans[i][j] + 1;
                q.offer(new Pair(i+1, j));
            }

            // Left
            if (j - 1 >= 0 && vis[i][j-1] == 0) {
                vis[i][j-1] = 1;
                ans[i][j-1] = ans[i][j] + 1;
                q.offer(new Pair(i, j-1));
            }

            // Right
            if (j + 1 < m && vis[i][j+1] == 0) {
                vis[i][j+1] = 1;
                ans[i][j+1] = ans[i][j] + 1;
                q.offer(new Pair(i, j+1));
            }
        }

        return ans;
    }
}
