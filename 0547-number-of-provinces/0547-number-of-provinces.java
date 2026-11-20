class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int ans =0;
        int n =isConnected.length;

        int []visited = new int [n];


        for(int i = 0;i<n;i++){
            if(visited[i]==0){
                ans++;
                dfs(i,isConnected,visited);
            }
        }
        return ans;
    }
    public void dfs(int node,int[][] isConnected, int []visited){
        visited[node] = 1;

        for(int j =0;j<isConnected.length;j++){
            if(isConnected[node][j]==1 && visited[j]==0){
                dfs(j,isConnected,visited);
            }
        }
    }
}