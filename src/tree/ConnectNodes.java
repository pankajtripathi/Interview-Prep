/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class ConnectNodes {
    public TreeLinkNode getNextRight(TreeLinkNode node){
        TreeLinkNode temp = node.next;
        while(temp != null){
            if(temp.left != null)
                return temp.left;
            if(temp.right != null)
                return temp.right;
            temp = temp.next;
        }
        return null;
    }
    
    public void connect(TreeLinkNode p) {
        if(p == null) return;
        p.next = null;
        
        while(p != null){
            TreeLinkNode q = p;
            
            while(q != null){
                if(q.left != null){
                    if(q.right != null)
                        q.left.next = q.right;
                    else
                        q.left.next = getNextRight(q);
                }
                if(q.right != null)
                    q.right.next = getNextRight(q);
                q = q.next;
            }
            
            if(p.left != null)
                p = p.left;
            else if(p.right != null)
                p = p.right;
            else p = getNextRight(p);
        }
        
    }
}