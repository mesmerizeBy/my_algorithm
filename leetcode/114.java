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
    public void flatten(TreeNode root) {
        if(root!=null)
        transfer(root);
        return ;
    }
    public TreeNode transfer(TreeNode r){
        if(r.left==null&&r.right==null) return r;
        TreeNode t=r.right;
        TreeNode l=r;
        if(r.left!=null){
            l=transfer(r.left);
            r.right=r.left;
            r.left=null;
            l.right=t;
        }
        if(t!=null)
            return transfer(t);
        return l;
    }
}