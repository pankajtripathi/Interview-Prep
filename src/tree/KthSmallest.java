/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        if(root == null) return -1;
        
        TreeNode curr = root;
        while(curr != null){
            st.push(curr);
            curr = curr.left;
        }
        int i=0;
        while(st.size()>0){
           curr = st.pop();
           i++;
           if(i == k) return curr.val;
           
           if(curr != null) curr = curr.right;
           
           while(curr != null){
              st.push(curr);
              curr = curr.left;
           }
        }
        return -1;
    }
}