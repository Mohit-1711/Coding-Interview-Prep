class Pair{
    int i;
    int j;

    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int [][] visited= new int[n][m];

        Queue<Pair> q = new ArrayDeque<>();

        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if( i==0 || i==n-1 || j==0 || j==m-1){ //putting boundary node = (1) inside the queue
                    if(grid[i][j]==1){
                        q.offer(new Pair(i,j));
                        visited[i][j] =1;
                    }
                }
            }
        }
        //bfs on the boundary 1's to mark the attached nodes with val 1 since those are invalid
        //MULTI SOURCE BFS - bfs on multiple nodes at once
        while(!q.isEmpty()){
            int size = q.size();

            for(int x =0;x<size;x++){
                Pair p = q.poll();
                int i =p.i;
                int j =p.j;

                //Up
                if(i-1>=0 && visited[i-1][j]==0 && grid[i-1][j]==1){
                    q.offer(new Pair(i-1,j));
                    visited[i-1][j]=1;
                }
                //down
                if(i+1<n && visited[i+1][j]==0 && grid[i+1][j]==1){
                    q.offer(new Pair(i+1,j));
                    visited[i+1][j]=1;
                }
                //left
                if(j-1>=0 && visited[i][j-1]==0 && grid[i][j-1]==1){
                    q.offer(new Pair(i,j-1));
                    visited[i][j-1]=1;
                }
                //right
                if(j+1<m && visited[i][j+1]==0 && grid[i][j+1]==1){
                    q.offer(new Pair(i,j+1));
                    visited[i][j+1]=1;
                }
            }
        }
        int count =0;
        //unvisited nodes which have a value 1 in grid are valid nodes
        for(int i =1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}