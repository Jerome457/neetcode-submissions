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
    public void reorderList(ListNode head) {
        int length=0;
        ListNode last=head;
        if(head==null)
            return;

        ListNode slow =head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode current=slow;
        current=current.next;
        slow.next=null;
        ListNode prev=null;

        while(current!=null){
            ListNode next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }

        current=head;

        while(current!=null && prev!=null){
            ListNode next=current.next;
            current.next=prev;
            ListNode next2=prev.next;
            prev.next=next;
            current=next;
            prev=next2;
        }
    }
}
