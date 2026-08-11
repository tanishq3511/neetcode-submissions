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
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int val){
        if(root == null){
            return 0;
        }
        if(root.val >= val){
            return 1 + dfs(root.left, root.val) + dfs(root.right, root.val);
        }

        return dfs(root.left, val) + dfs(root.right, val);
    }
}
