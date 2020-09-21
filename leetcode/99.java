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
    private TreeNode err1,err2;
    public void recoverTree(TreeNode root) {
        List<TreeNode> L=new LinkedList<TreeNode>();
        dfs(root,L);
        err1.val=err2.val-err1.val;
        err2.val=err2.val-err1.val;
        err1.val=err2.val+err1.val;
        return ;
    }
    private void dfs(TreeNode r,List<TreeNode> L){
        if(r==null)return;
        dfs(r.left,L);
        if(L.size()>0&&L.get(L.size()-1).val>r.val){
            if(err1==null){
                err1=L.get(L.size()-1);
                err2=r;
            }
            else{
                err2=r;
            }
                
        }
        L.add(r);
        dfs(r.right,L);
    }
}