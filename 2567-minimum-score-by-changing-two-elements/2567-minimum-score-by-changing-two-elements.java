class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // Idea is since we are allowed to change 2 numbers we change these number to same value so low score is always 0
        //So we just calc the highscore assuming that we changed the 2 nums for all three cases and choose minimum
        int changeSmallest = nums[n-1]-nums[2];
        int changeLargest = nums[n-3]-nums[0];
        int changeCorner = nums[n-2]-nums[1];

        return Math.min(changeCorner, Math.min(changeSmallest,changeLargest));
    }
}