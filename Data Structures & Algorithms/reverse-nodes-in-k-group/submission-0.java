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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        int length=0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }

        int groups=length/k;
        temp=head;
        ListNode tail=null;
        ListNode head2=head;
        for(int i=0;i<groups;i++){
            ListNode prev=null;
            ListNode current=temp;
            ListNode next=current.next;
            for(int j=0;j<k;j++){
                current.next=prev;
                prev=current;
                current=next;
                if(current==null)
                    continue;
                next=current.next;
            }
            if(tail!=null)
                tail.next=prev;
            tail=temp;
            temp=current;
            if(i==0)
                head=prev;
        }
        if (temp!=null)
            tail.next=temp;
        return head;
    }
}
