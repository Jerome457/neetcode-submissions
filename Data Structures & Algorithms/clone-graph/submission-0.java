/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node,Node> copy = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        if(copy.containsKey(node))
            return copy.get(node);

        Node n= new Node(node.val);
        copy.put(node,n);
        for(Node a: node.neighbors){
            Node temp= cloneGraph(a);
            if(temp!=null)
                n.neighbors.add(temp);
        }
        return n;
    }
}