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
        return 1 + dfs(root.left, root.val) + dfs(root.right, root.val);
    }

    public int dfs(TreeNode node, int max){
        if(node == null) return 0;

        int res = 0;
        int m = max;
        if(node.val >= max){
            res++;
            m = node.val;
        }

        res += dfs(node.left, m) + dfs(node.right, m);
        return res;
    }
}
