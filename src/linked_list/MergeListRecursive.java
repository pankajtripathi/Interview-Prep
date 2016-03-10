package linked_list;

/**
 * @author pankajtripathi
 * */
public class MergeListRecursive {
	public Node mergeTwoLists(Node l1, Node l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		if(l1.data < l2.data){
			l1.link=mergeTwoLists(l1.link,l2);
			return l1;
		}
		else{
			l2.link=mergeTwoLists(l2.link,l1);
			return l2;
		}
	}
}



