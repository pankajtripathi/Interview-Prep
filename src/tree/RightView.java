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
public class RightView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> res = new LinkedList<Integer>();
        
        if(root == null) return res;
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size;i++){
                TreeNode t = q.poll();
                if(i == 0) res.add(t.val);
                if(t.right != null) q.add(t.right);
                if(t.left != null) q.add(t.left);
            }
        }
        return res;
    }
}