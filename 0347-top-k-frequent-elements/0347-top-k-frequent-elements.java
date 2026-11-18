class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(map.get(b), map.get(a)) //desc order sort based on freq <key,val> val is the freq
        );

        for (int num : map.keySet()) {
            maxHeap.offer(num);
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) { //taking out top k freq
            res[i] = maxHeap.poll();
        }

        return res;
    }
}