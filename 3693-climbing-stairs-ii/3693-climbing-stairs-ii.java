class Solution {
    public int climbStairs(int n, int[] costs) {

        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        return calcCost(n,dp,costs);
    }
    public int calcCost(int i, int dp[], int cost[]){
        if(i==0){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        if(i>=1){
            ans = Math.min(ans, calcCost(i-1,dp,cost)+cost[i-1]+1);
        }
        if(i>=2){
            ans = Math.min(ans, calcCost(i-2,dp,cost)+cost[i-1]+4);
        }
        if(i>=3){
            ans = Math.min(ans, calcCost(i-3,dp,cost)+cost[i-1]+9);
        }
        dp[i] = ans;

        return ans;
    }
}