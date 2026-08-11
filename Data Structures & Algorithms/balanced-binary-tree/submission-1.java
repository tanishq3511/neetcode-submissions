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
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[] {1, 0};
        }
        
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] res = new int[2];

        if(left[0] == 1 && right[0]==1 && left[1]-right[1]<=1 && right[1]-left[1]<=1){
            res[0] = 1;
        }else{
            res[0] = 0;
        }

        res[1] = 1 + Math.max(left[1], right[1]);

        return res;
    }
}
