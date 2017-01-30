/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    public boolean isBST(TreeNode node, double min, double max){
        if(node == null) return true;
        if(node.val <= min || node.val >= max) return false;
        return (isBST(node.left, min, node.val) && isBST(node.right, node.val, max));
    }
}