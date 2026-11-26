class Solution {
    public boolean canAliceWin(int n) {
        if(n<10){
            return false;
        }
        int val = 10;
        while(n!=0){
            
            n-= val;
            if(n<0 && val%2==0){
                return false;
            }
            else if(n<0){
                return true;
            }
            val--;
        }
        return val%2!=0;
    }
}