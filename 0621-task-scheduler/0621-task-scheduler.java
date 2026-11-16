class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int freq[] = new int[26];

        int time =0;

        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        for (int f : freq) {
            if (f > 0) {
                pq.add(f);
            }
        }
        while (!pq.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 1; i <=n + 1; i++) {
                if (!pq.isEmpty()) {    
                    int currTaskFreq = pq.poll();
                    currTaskFreq--;
                    temp.add(currTaskFreq);
                }
            }
            for(int f : temp){
                if(f>0){
                    pq.add(f);
                }
            }

            if(pq.isEmpty()){
                time+=temp.size();
            }else{
                time+=n+1;
            }
             
        }
        return time;
    }
}