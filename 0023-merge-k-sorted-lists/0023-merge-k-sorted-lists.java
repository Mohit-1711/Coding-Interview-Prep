/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list = new ArrayList<>();
        //put all the elements inside the Integer list
        for(int i =0;i<lists.length;i++){
            ListNode temp = lists[i];

            while(temp!=null){
                list.add(temp.val);
                temp=temp.next;
            }
        }
        //sort the list
        Collections.sort(list);
        //convert Integer list to LinkedList and return its head
        return convert(list);
    }

    public ListNode convert(List<Integer> list){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(int i =0;i<list.size();i++){
            curr.next = new ListNode(list.get(i));
            curr=curr.next;

        }
        return dummy.next;
    }
}