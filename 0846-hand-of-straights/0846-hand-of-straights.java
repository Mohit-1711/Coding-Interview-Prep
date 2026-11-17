
import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        int n = hand.length;

        if (n % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (!map.isEmpty()) {

            int first = map.firstKey(); //smallest available number

            for (int i = 0; i < groupSize; i++) { //forming group of given size

                int curr = first + i;

                
                if (!map.containsKey(curr)){ //if next number does not exist
                    return false;
                }

                
                int freq = map.get(curr);

                if (freq == 1) { // Decrease frequency of used no./remove
                    map.remove(curr);
                } else {
                    map.put(curr, freq - 1);
                }
            }
        }

        return true;
    }
}
