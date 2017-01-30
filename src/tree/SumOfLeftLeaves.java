/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return 0;
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            if(t.left != null){
                q.add(t.left);
                if(t.left.left == null && t.left.right == null) sum += t.left.val;
            } 
            if(t.right != null) q.add(t.right);
        }
        return sum;
    }
}