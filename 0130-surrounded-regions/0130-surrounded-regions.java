class Pair{
    int i;
    int j;
    
    Pair(int i, int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        Queue<Pair> q= new ArrayDeque<>();
        int [][]visited = new int [n][m];
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if((i==0 || i==n-1 || j==0 || j==m-1) &&(board[i][j]=='O')){
                q.offer(new Pair(i,j));
                visited[i][j] =1;
            }
        }
    }

    while(!q.isEmpty()){

        Pair p = q.poll();
        int i =p.i;
        int j =p.j;

        //Up
        if(i-1>=0 && board[i-1][j]=='O' && visited[i-1][j]==0){
            q.offer(new Pair(i-1,j));
            visited[i-1][j]=1;
        }
        //down
        if(i+1<n && board[i+1][j]=='O' && visited[i+1][j]==0){
            q.offer(new Pair(i+1,j));
            visited[i+1][j]=1;
        }
        //left
        if(j-1>=0 && board[i][j-1]=='O' && visited[i][j-1]==0){
            q.offer(new Pair(i,j-1));
            visited[i][j-1]=1;
        }
        //right
        if(j+1 <m && board[i][j+1]=='O' && visited[i][j+1]==0){
            q.offer(new Pair(i,j+1));
            visited[i][j+1]=1;
        }
    }

    for(int i=1;i<n-1;i++){
        for(int j=1;j<m-1;j++){
            if(visited[i][j]==0 && board[i][j]=='O'){
                board[i][j]='X';
            }
        }
    }
    }
}