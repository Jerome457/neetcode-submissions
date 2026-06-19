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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null)
            return null;
        
        ListNode current1=l1;
        ListNode current2=l2;
        ListNode prev=current1;
        int carry=0;
        while(current1!=null && current2!=null){
            current1.val=current1.val+current2.val+carry;
            carry=0;
            carry=current1.val/10;
            current1.val=current1.val%10;
            prev=current1;
            current1=current1.next;
            current2=current2.next;
        }

        if(current2!=null){
            prev.next=current2;
            current1=current2;
        }

        while(current1!=null){
            current1.val=current1.val+carry;
            carry=0;
            carry=current1.val/10;
            current1.val=current1.val%10;
            prev=current1;
            current1=current1.next;
        }

        if(carry>0){
            ListNode temp= new ListNode(carry);
            carry=0;
            prev.next=temp;
        }
        return l1;

    }
}
