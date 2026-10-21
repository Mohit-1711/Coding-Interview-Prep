class Solution {
    public int minOperations(String s) {

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        String sorted = new String(arr);

        if (s.equals(sorted)) {
            return 0;
        }
        if (s.length() == 2) {
            return -1;
        }

        char smallest = 'z';
        char largest = 'a';
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            smallest = (char) Math.min(smallest, c);
            largest = (char) Math.max(largest, c);
        }
        if (s.charAt(0) == smallest || s.charAt(n - 1) == largest) {
            return 1;
        }
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == smallest || s.charAt(i) == largest) {
                return 2;
            }
        }
        return 3;

    }
}