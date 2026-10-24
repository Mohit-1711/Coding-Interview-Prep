class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int startA = findDay(arriveAlice,days);
        int leaveA = findDay(leaveAlice,days);
        int startB = findDay(arriveBob,days);
        int leaveB = findDay(leaveBob,days);

        int finalArrival = Math.max(startA,startB);
        int finalLeave = Math.min(leaveA,leaveB);
        return Math.max(0,finalLeave-finalArrival+1); //+1 cz leave date is counted as well


    }
    public int findDay(String current, int[] days){
        String[] curr = current.split("-");

        int day = Integer.valueOf(curr[1]);
        int month = Integer.valueOf(curr[0]);

        int total  = day;

        for(int i =0;i<month-1;i++){
            total+= days[i];
        }
        return total;
    }
}