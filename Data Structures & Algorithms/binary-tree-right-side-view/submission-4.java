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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int last = Integer.MAX_VALUE;
            for(int i = q.size(); i > 0; i--){
                TreeNode node = q.poll();
                if(node != null){
                    q.add(node.left);
                    q.add(node.right);
                    last = node.val;
                }
            }
            if(last != Integer.MAX_VALUE) res.add(last);
        }

        return res;
    }
}
