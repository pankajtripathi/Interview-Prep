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
public class BTPaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new LinkedList<String>();
        if(root == null) return ans;
        search(root,"",ans);
        return ans;
    }
    
    public void search(TreeNode root, String path, List<String> ans){
        if(root.left == null && root.right ==null) ans.add(path + root.val);
        if(root.left != null) search(root.left, path+root.val + "->", ans);
        if(root.right != null) search(root.right, path+root.val + "->", ans);
    }
}