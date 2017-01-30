/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Base case
        if(root == null)
            return null;
            
        //root data is ancestor
        if(root == p || root == q)
            return root;
        
        // traverse tree to check the node in left and right subtree
        TreeNode la = lowestCommonAncestor(root.left, p , q);
        TreeNode ra = lowestCommonAncestor(root.right, p , q);
        
        // if the above values are no null then the nodes are in the left and right subtrees respectively
        if(la != null && ra != null)
        return root;
        else if(la == null && ra == null)
        return null;
        else return la==null?ra:la;
    }
}