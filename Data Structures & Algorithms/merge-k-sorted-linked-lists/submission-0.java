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
        PriorityQueue<Integer> a= new PriorityQueue<>();
        for(int i=0;i<lists.length;i++){
            ListNode temp = lists[i];
            while (temp!=null){
                a.add(temp.val);
                temp=temp.next;
            }
        }
        System.out.println(a);
        ListNode head= new ListNode(0);
        ListNode current=head;
        while(a.peek()!=null){
            int c= a.poll();
            ListNode temp= new ListNode(c);
            current.next=temp;
            current=current.next;
        }
        return head.next;
    }
}
