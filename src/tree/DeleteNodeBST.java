/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(key > root.val)
            root.right = deleteNode(root.right, key);
        else if(key < root.val)
            root.left = deleteNode(root.left, key);
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            root.val = minVal(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    
    private int minVal(TreeNode node){
        int min = node.val;
        while(node.left != null){
            min = node.left.val;
            node = node.left;
        }
        return min;
    }
}