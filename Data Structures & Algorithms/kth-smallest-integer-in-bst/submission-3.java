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
    public int kthSmallest(TreeNode root, int k) {
        int[] kth = new int[2];
        kth[0] = k;

        dfs(root, kth);
        return kth[1];
    }

    public void dfs(TreeNode node, int[] kth){
       if(node == null) return;

       dfs(node.left, kth);
       if(kth[0] == 0) return;

       kth[0] -= 1;

       if(kth[0] == 0){
        kth[1] = node.val;
        return;
       }

       dfs(node.right, kth);
    }
}
