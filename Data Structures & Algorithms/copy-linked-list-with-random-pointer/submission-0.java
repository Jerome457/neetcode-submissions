/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node current=head;
        Node head2= new Node(0);
        Node current2=head2;
        HashMap<Node,Node> map= new HashMap<>();
        while(current!=null){
            Node arr= new Node(current.val);
            current2.next=arr;
            map.put(current,arr);
            current2=current2.next;
            current=current.next;
        }

        head2=head2.next;
        current=head;
        current2=head2;
        while(current!=null){
            Node temp= map.get(current.random);
            current2.random=temp;
            current2=current2.next;
            current=current.next;
        }
        return head2;
    }
}
