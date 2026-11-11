class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //Collections.reverseOrder() make a maxHeap

        for(int num : nums){
            minHeap.add(num);

            if(minHeap.size()>k){
                minHeap.poll(); //minHeap poll removes the smallest number
            }
        }
        //end of the loop only 5,6 remains for eg:1
        return minHeap.peek();
    }
}