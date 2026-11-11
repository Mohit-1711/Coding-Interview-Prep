class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        
        if(need1==0 && need2==0){
            return 0;
        }
        long ans =0;
        long bestBoth = Math.min(costBoth, (long)cost1+cost2); // best price if buying both
        
        int commonNeed = Math.min(need1,need2); //basically no. of pairs including (type1 & type2) both

        ans+= (long)commonNeed*bestBoth;
        need1-=commonNeed;
        need2-=commonNeed;

        //if one of the needs becomes 0
        ans+= (long)need1* Math.min(cost1,bestBoth); 
        ans+= (long)need2* Math.min(cost2,bestBoth);
        
        return ans;
    }
}