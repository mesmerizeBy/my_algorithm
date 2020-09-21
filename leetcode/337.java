/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<TreeNode,Integer> M=new HashMap<TreeNode,Integer>();
    public int rob(TreeNode root) {
        int max=Math.max(getsum(true,root),getsum(false,root));
        return max;
    }
    private int getsum(boolean t,TreeNode r){
        if(r==null) return 0;
        if(t){
            Integer max=M.get(r);
            if(M.get(r)!=null) return max;
            max=r.val+getsum(!t,r.left)+getsum(!t,r.right);
            M.put(r,max);
            return max;
        }
        else{
            int max=Math.max(getsum(t,r.left),getsum(!t,r.left));
            max+=Math.max(getsum(!t,r.right),getsum(t,r.right));
            return max;
        }
    }
}