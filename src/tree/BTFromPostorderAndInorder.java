/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BTFromPostorderAndInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0;
        int inEnd=inorder.length-1;
        int postStart = 0;
        int postEnd=postorder.length-1;
        
        return build(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }
    
    public TreeNode build(int inorder[], int inStart, int inEnd, int postorder[], int postStart, int postEnd){
        if(inStart>inEnd || postStart>postEnd)
            return null;
            
        int val = postorder[postEnd];
        TreeNode node = new TreeNode(val);
        
        int inIndex = 0;
        for(int i=0; i<inorder.length; i++){
            if(val == inorder[i]){
                inIndex = i;
                break;
            }
        }
        
        node.left = build(inorder, inStart, inIndex-1, postorder, postStart, postStart+inIndex-(inStart+1));
        node.right = build(inorder, inIndex+1, inEnd, postorder, postStart+inIndex-inStart, postEnd-1);
        
        return node;
    }
}