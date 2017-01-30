/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        int lsh = height(root.left);
        int rsh = height(root.right);
        
        return Math.abs(lsh - rsh) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    int height(TreeNode node){
        if(node == null) return 0;
        else{
            int lh = height(node.left);
            int rh = height(node.right);
            
            return Math.max(lh, rh)+1;
        }
    }
}