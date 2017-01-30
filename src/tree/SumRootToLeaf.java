/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumRootToLeaf {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        return sumNumbersOp(root, sum);
    }
    public int sumNumbersOp(TreeNode root, int sum){
        if(root == null) return 0;
        sum = sum*10 + root.val;
        if(root.left == null && root.right == null) return sum;
        int ls = sumNumbersOp(root.left, sum);
        int rs = sumNumbersOp(root.right, sum);
        return ls + rs;
    }
}