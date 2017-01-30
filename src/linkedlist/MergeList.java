package linked_list;

/**
 * @author pankajtripathi
 * */
public class MergeList {
	public Node MergeLists(Node headA, Node headB) {
    
    Node p = headA, q = headB;

    //Create a node head and a reference for it.
    Node head = new Node();
    Node h = head;
    
    // Traverse for same number of elements. For smaller number let h.next = node and keep h moving. 
    while(p != null && q != null){
        if(p.data < q.data){
           h.next = p;
           p = p.next;
        }
        else{
           h.next = q;
           q = q.next;
        }
        h = h.next;
    }
    
    // Add other nodes to h.next
    if(p != null){
        h.next = p;
    }
    if(q != null){
        h.next = q;
    }
    
    return head.next;
}



