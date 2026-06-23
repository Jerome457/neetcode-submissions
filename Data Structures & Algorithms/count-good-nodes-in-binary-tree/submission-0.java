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
    public int goodNodes(TreeNode root) {
        return dfs(Integer.MIN_VALUE,root);
    }

    int dfs(int max,TreeNode root){
        if(root==null)
            return 0;
        int count=0;
        if(root.val>=max)
            count=1;
        max=Math.max(max,root.val);
        return count+dfs(max,root.left)+dfs(max,root.right);
    }
}
