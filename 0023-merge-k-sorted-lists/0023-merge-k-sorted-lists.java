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
class Pair{
    Integer val;
    ListNode node;
    Pair(int val,ListNode node){
        this.val = val;
        this.node = node;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
     PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> //so that pq knows store sorted pair based on values
        Integer.compare(a.val,b.val));

     int n = lists.length;

     for(int i = 0;i<n;i++){
        ListNode temp = lists[i];

        while(temp!=null){
            pq.add(new Pair(temp.val,temp));
            temp=temp.next;
        }
     }
     ListNode dummy= new ListNode(-1);
     ListNode temp = dummy;

     while(!pq.isEmpty()){
        Pair curr = pq.poll();
        temp.next = curr.node;
        temp = temp.next;
     }
     temp.next=null;// making last node point to null
     return dummy.next;
    }
}