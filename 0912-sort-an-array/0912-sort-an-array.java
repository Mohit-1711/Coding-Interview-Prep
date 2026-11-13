class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = n / 2; i >= 0; i--) {
            buildMaxHeap(nums, n, i);
        }
        while (n > 0) {
            //steap 1 always swap first element with the last element of window size n 
            int temp = nums[0];
            nums[0] = nums[n - 1];
            nums[n - 1] = temp;
            n--; // shrink

            //put the node that came to the first index at its correct maxheap position
            buildMaxHeap(nums, n, 0);
        }
        return nums;

    }

    public void buildMaxHeap(int arr[], int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            buildMaxHeap(arr, n, largest);
        }
    }
}