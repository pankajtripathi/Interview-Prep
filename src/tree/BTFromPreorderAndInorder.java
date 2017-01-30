/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class BTFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0, inStart = 0;
        int preEnd = preorder.length -1, inEnd = inorder.length -1;
        
        return build(preorder, preStart, preEnd, inorder, inStart, inEnd);
        
    }
    public TreeNode build(int preorder[], int preStart, int preEnd, int inorder[], int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd)
            return null;
            
        int val = preorder[preStart];
        TreeNode node = new TreeNode(val);
        
        int inIndex = 0;
        for(int i=0; i<inorder.length; i++){
            if(val == inorder[i])
                inIndex = i;
        }
        
        node.left = build(preorder, preStart+1, preStart+(inIndex-inStart),inorder, inStart, inIndex-1);
        node.right = build(preorder, preStart+(inIndex-inStart)+1, preEnd, inorder, inIndex+1, inEnd);
        
        return node;
    }
}