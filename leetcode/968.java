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
    public int minCameraCover(TreeNode root) {
        int[] ans=dfs(root);
        return ans[1];
    }
    public int[] dfs(TreeNode root){
        if(root==null){
            return new int[]{
                Integer.MAX_VALUE/2,
                0,0
            };
        }
        int[] fl=dfs(root.left);
        int[] fr=dfs(root.right);
        int[] array = new int[3];
        array[0] = fl[2] + fr[2] + 1;//当前节点放摄像头所需的监控整棵树所需的摄像头数目
        array[1] = Math.min(array[0], Math.min(fl[0] + fr[1], fr[0] + fl[1]));//无论当前结点是否放置摄像头监控整棵树所需的摄像头数目
        array[2] = Math.min(array[0], fl[1] + fr[1]);//覆盖两棵子树需要的摄像头数目，无论当前节点 本身是否被监控到。
        return array;


    }
}