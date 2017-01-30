/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaximumPathSum {
    int globalMax = Integer.MIN_VALUE;
    public int calculateMax(TreeNode root){
        if(root == null) return 0;
        int ls = calculateMax(root.left);
        int rs = calculateMax(root.right);
        
        int singleTree = Math.max(root.val, Math.max(ls+root.val, rs+root.val));
        globalMax = Math.max(globalMax, Math.max(singleTree, ls+rs+root.val));
        
        return singleTree;
    }
    
    public int maxPathSum(TreeNode root) {
        calculateMax(root);
        return globalMax;
    }
}