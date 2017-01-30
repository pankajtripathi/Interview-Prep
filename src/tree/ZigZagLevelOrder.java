/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        int level = 0;
        if(root == null) return res;
        q.add(root);
        
        while(!q.isEmpty()){
            List<Integer> il = new LinkedList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode t = q.poll();
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
                il.add(t.val);
            }
            if(level % 2 != 0) Collections.reverse(il);
            level++;
            res.add(il);
        }
        return res;
    }
}