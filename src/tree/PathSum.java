/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> values = new LinkedList<Integer>();
        
        if(root == null) return false;
        q.add(root);
        values.add(root.val);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            int max = values.poll();
            if(max == sum && t.left == null && t.right == null) return true;
            
            if(t.left != null){
                q.add(t.left);
                values.add(max+t.left.val);
            }
            
            if(t.right != null){
                q.add(t.right);
                values.add(max+t.right.val);
            }
        }
        return false;
    }
}