class Solution {
    public int minMoves(int[] nums) {
        
        int maxNum=0;
        for(int num : nums){
            maxNum = Math.max(num,maxNum);
        }
        int moves =0;
        for(int num : nums){
            moves+=maxNum-num;
        }
        return moves;
    }
}