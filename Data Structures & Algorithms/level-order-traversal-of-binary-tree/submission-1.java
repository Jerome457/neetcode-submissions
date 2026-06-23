/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> a= new ArrayDeque<>();
        TreeNode current=root;
        
        int height=0;
        List<List<Integer>> arr= new ArrayList<>();
        if(root==null)
            return arr;
        a.add(root);
        while(!a.isEmpty()){
            int n=a.size();
            List<Integer> b = new ArrayList<>();
            for(int i=0;i<n;i++){
                current=a.poll();
                System.out.println(height+ " "+ current.val+ " "+ i);
                if(current.left!=null)
                    a.add(current.left);
                if(current.right!=null)
                    a.add(current.right);
                b.add(current.val);
            }
            arr.add(b);
            height++;
        }
        return arr;
    }
}
