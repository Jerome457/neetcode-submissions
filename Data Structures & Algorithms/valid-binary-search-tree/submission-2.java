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
    public boolean isValidBST(TreeNode root) {
        return validation(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    boolean validation(TreeNode root,int low,int high){
        if(root==null)
            return true;
        boolean left=false,right=false;
        left= validation(root.left,low,root.val);
        right= validation(root.right,root.val,high);


        return left&&right&& (root.val<high && root.val>low)?true:false;
    }
}
