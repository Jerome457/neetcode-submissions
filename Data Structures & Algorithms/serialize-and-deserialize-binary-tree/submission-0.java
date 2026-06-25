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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null){
            return "N#";
        }

        return root.val+"#"+serialize(root.left)+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    int index=0;
    public TreeNode deserialize(String data) {
        String s="";
        while(data.charAt(index)!='#'){
            s+=data.charAt(index);
            index++;
        }
        index++;
        if(s.equals("N")){
            return null;
        }
        else{
            TreeNode temp= new TreeNode(Integer.parseInt(s));
            temp.left=deserialize(data);
            temp.right=deserialize(data);
            return temp;
        }
    }
}
