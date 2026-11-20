class Pair{
    int i;
    int j;

    Pair(int i, int j ){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        
        int n  = grid.length;
        int m  = grid[0].length;
        int visited[][] = new int[n][m];
        int ans=0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]=='1' && visited[i][j]==0){
                    ans++;
                    bfs(i,j,visited,grid);
                }
            }
        }
        return ans;
        
    }
    public void bfs(int i, int j, int visited[][], char[][] grid) {

    int n = grid.length;
    int m = grid[0].length;

    Queue<Pair> q = new ArrayDeque<>();

    q.offer(new Pair(i, j));
    visited[i][j] = 1;

    while (!q.isEmpty()) {

        Pair currNode = q.poll();

        int a = currNode.i;
        int b = currNode.j;

        // Down
        if (a+1 < n && grid[a+1][b] == '1' && visited[a+1][b] == 0) {
            visited[a+1][b] = 1;
            q.offer(new Pair(a+1, b));
        }

        // Up
        if (a-1 >= 0 && grid[a-1][b] == '1' && visited[a-1][b] == 0) {
            visited[a-1][b] = 1;
            q.offer(new Pair(a-1, b));
        }

        // Left
        if (b-1 >= 0 && grid[a][b-1] == '1' && visited[a][b-1] == 0) {
            visited[a][b-1] = 1;
            q.offer(new Pair(a, b-1));
        }

        // Right
        if (b+1 < m && grid[a][b+1] == '1' && visited[a][b+1] == 0) {
            visited[a][b+1] = 1;
            q.offer(new Pair(a, b+1));
        }
    }
}
}