class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;

        long even = 1;
        long odd = 0;
        long ans = 0;
        int currSum = 0;

        for (int num : arr) {
            currSum += num;

            if (currSum % 2 == 0) {
                ans = (ans + odd) % MOD;
                even++;
            } else {
                ans = (ans + even) % MOD;
                odd++;
            }
        }

        return (int) ans;
    }
}