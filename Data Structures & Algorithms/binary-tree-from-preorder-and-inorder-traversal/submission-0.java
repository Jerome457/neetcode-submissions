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
    int current=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> arr= new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            arr.put(inorder[i],i);
        return build(preorder,arr,0,preorder.length);
    }

    TreeNode build(int [] preorder,HashMap<Integer,Integer>a,int l,int r){
        if(l>=r)
            return null;
        TreeNode temp= new TreeNode(preorder[current]);
        System.out.println(preorder[current]);
        int mid=a.get(preorder[current]);
        current++;
        temp.left=build(preorder,a,l,mid);
        temp.right=build(preorder,a,mid+1,r);
        return temp;
    }
}
