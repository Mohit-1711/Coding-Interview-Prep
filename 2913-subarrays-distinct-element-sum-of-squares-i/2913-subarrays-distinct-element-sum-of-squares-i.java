class Solution {
    public int sumCounts(List<Integer> nums) {
        
        int n = nums.size();
        int ans =0;
        for(int i =0;i<n;i++){
            HashSet<Integer> set = new HashSet<>();
            int distinct = 0;
            for(int j = i;j<n;j++){
                if(!set.contains(nums.get(j))){
                    set.add(nums.get(j));
                    distinct++;
                }
                ans+= distinct*distinct;
            }
        }
        return ans;
    }
}