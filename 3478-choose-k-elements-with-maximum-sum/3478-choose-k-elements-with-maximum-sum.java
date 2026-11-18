class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {

        // int n = nums1.length;
        // long[] res = new long[n];

        // for(int i = 0; i < n; i++) {

        //     ArrayList<Integer> idx = new ArrayList<>();

        //     for(int j = 0; j < n; j++) {
        //         if(nums1[i] > nums1[j]) {
        //             idx.add(j);
        //         }
        //     }

        //     PriorityQueue<Integer> pq = new PriorityQueue<>();

        //     for(int index : idx) {
        //         pq.add(nums2[index]);

        //         if(pq.size() > k) {
        //             pq.poll();
        //         }
        //     }

        //     long sum = 0;

        //     while(!pq.isEmpty()) {
        //         sum += pq.poll();
        //     }

        //     res[i] = sum;
        // }

        // return res;

        int n = nums1.length;
        int arr[][] = new int[n][3];
        long res[] = new long[n];
        for(int i =0;i<n;i++){
            arr[i][0] = nums1[i];
            arr[i][1] = i;
            arr[i][2] = nums2[i];

        }
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Arrays.sort(arr,(a,b)-> Integer.compare(a[0],b[0]));

        long sum=0;
        for(int i=0;i<n;i++){
            if(i>0 && arr[i][0]==arr[i-1][0]){
                res[arr[i][1]]=res[arr[i-1][1]];
            }else{
                res[arr[i][1]]=sum;
            }
            sum+=(long)arr[i][2];
            pq.add((long)arr[i][2]);
            if(pq.size()>k){
                sum-=pq.poll();
            }
        }
        return res;
    }
}