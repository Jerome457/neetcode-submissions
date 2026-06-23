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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> arr= new ArrayList<Integer>();
        if(root==null)
            return arr;
        Deque<TreeNode> a= new ArrayDeque<>();
        a.add(root);
        while(!a.isEmpty()){
            int n=a.size();
            for(int i=0;i<n;i++){
                TreeNode current=a.poll();
                if(current.left!=null)
                    a.add(current.left);
                if(current.right!=null)
                    a.add(current.right);
                if(i==n-1)
                    arr.add(current.val);
            }
        }
        return arr;
    }
}
