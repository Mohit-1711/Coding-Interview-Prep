class Solution {
    public String maxSumOfSquares(int num, int sum) {

        if(sum>9*num){
            return "";
        }        
        StringBuilder res = new StringBuilder();

        for(int i =0;i<num;i++){
            int digit = Math.min(9,sum); //choosing to add 9 or sum itself if sum < 9
            res.append(digit);
            sum-=digit;
        }

        while(res.length()<num){
            res.append('0');
        }
        return res.toString();
    }
}