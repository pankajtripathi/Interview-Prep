/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PostOrderWithStack {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> st =new Stack<TreeNode>(); 
        if(root == null) return res;
        st.push(root);
        while(!st.empty()){
            TreeNode t = st.peek();
            if(t.left == null && t.right == null){
                TreeNode pop = st.pop();
                res.add(pop.val);
            }
            else{
                if(t.right != null){
                    st.push(t.right);
                    t.right = null;
                }
                if(t.left != null){
                    st.push(t.left);
                    t.left = null;
                }
            }
        }
        return res;
    }
}