class Solution {
    public int minMoves(int[] nums) {

        int minVal = Integer.MAX_VALUE;
        //increasing n-1 numbers at once = decreasing one number by 1
        //so we count number of moves taken to make all number = min num 
        for(int num : nums){
            minVal = Math.min(num,minVal);
        }

        int moves =0;

        for(int num:nums){
            moves+= num-minVal;
        }
        return moves;
    }
}