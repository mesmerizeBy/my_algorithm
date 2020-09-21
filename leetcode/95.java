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
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
        return new ArrayList<TreeNode>();
        return g(1,n);
    }
    private List<TreeNode> g(int start, int end){
        List<TreeNode> allTrees =new ArrayList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        // 枚举可行根节点
        for (int i = start; i <= end; ++i) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = g(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = g(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode  left : leftTrees) {
                for (TreeNode  right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;

    }
}