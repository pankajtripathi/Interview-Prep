/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> fl = new LinkedList<List<Integer>>();
        List<List<Integer>> frl = new LinkedList<List<Integer>>();
        
        if(root == null) return fl;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> il = new LinkedList<Integer>();
            int qsize = q.size();
            for(int i=0; i<qsize; i++){
               if(q.peek().left != null) q.add(q.peek().left);
               if(q.peek().right != null) q.add(q.peek().right);
               il.add(q.poll().val);
            }
            fl.add(il);
        }
        for(int i=fl.size()-1; i>=0; i--)
            frl.add(fl.get(i));
        return frl;
    }
}