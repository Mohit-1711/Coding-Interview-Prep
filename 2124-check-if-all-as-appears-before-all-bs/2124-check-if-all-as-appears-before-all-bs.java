class Solution {
    public boolean checkString(String s) {
        boolean findB = false;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='b'){
                findB=true;
            }
            if(findB && ch=='a'){
                return false;
            }
        }
        return true;
    }
}