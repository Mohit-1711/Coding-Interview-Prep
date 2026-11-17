class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;

        if(n%k!=0){
            return false;
        }

        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        while(!map.isEmpty()){
            int first = map.firstKey();

            for(int i =0;i<k;i++){ // NOTE : at i=0 we are decreasing the freq. of the first smallest
                int next  = first+i;
                if(!map.containsKey(next)){
                    return false;
                }
                int freq = map.get(next);

                if(freq==1){
                    map.remove(next);
                }else{
                    map.put(next,freq-1);
                }
            }
        }
        return true;

    }
}