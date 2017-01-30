/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class ConnectNodesII {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        if(root == null) return;
        
        q.add(root);
        q.add(null);
        
        while(true){
            TreeLinkNode curr = q.poll();
            if(curr != null){
                curr.next = q.peek();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            else if(!q.isEmpty())
                q.add(null);
            else break;
        }
    }
}