class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        long ans = 0;
        int currSum = 0;

        for (int num : arr) {
            currSum += num;

            if (currSum % 2 == 0) {
                ans = (ans + map.getOrDefault(1, 0)) % MOD;
            } else {
                ans = (ans + map.getOrDefault(0, 0)) % MOD;
            }

            int remainder = currSum % 2;
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return (int) ans;
    }
}