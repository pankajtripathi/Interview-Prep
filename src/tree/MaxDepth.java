/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        else{
            int ld = maxDepth(root.left);
            int rd = maxDepth(root.right);
            
            return Math.max(ld, rd) + 1;
        }
    }
}