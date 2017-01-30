/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.LinkedList;
import java.util.Queue;
public class PreOrderWithStack {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        if(root == null) return res;
        st.push(root);
        while(!st.empty()){
            TreeNode t = st.pop();
            res.add(t.val);
            if(t.right!= null) st.push(t.right);
            if(t.left!= null) st.push(t.left);
        }
        return res;
    }
}