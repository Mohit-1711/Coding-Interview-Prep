class Solution {
    public long maxAlternatingSum(int[] nums) {
    
    int n = nums.length;
    for(int i=0;i<n;i++){
        nums[i]= Math.abs(nums[i]);
    }
     Arrays.sort(nums);

     long ans = 0;
     
     
     for(int i =0;i<n;i++){
        long val = nums[i];
        if(i<n/2){ // first half will be at subtract postion
            ans-= val*val;
        }
        else{ // second half at adding postion
            ans+= val*val;
        }
     }
     return ans;

    }
}