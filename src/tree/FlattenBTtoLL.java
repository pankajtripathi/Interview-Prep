/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class FlattenBTtoLL{
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode node = root;
        
        while(node.left != null || node.right!= null){
            if(node.left != null){
                TreeNode rc = node.right;
                node.right = node.left;
                node.left = null;
                TreeNode rm = node.right;
                while(rm.right != null){
                    rm = rm.right;
                }
                rm.right = rc;
            }
            node = node.right;
        }
    }
}