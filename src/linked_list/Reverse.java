package linked_list;

/**
 * @author pankajtripathi
 * */
public class Reverse {

	static Node head=null;
	/**
	 * Append the node at start if there is no existing node.
	 * else traverse to the end of the list and add a new node.
	 * */
	public static void append(int num){
		if(head==null){
			Node temp=new Node();
			temp.data=num;
			temp.link=null;
			head=temp;
		}
		else{
			Node p=head;
			while(p.link!=null)
				p=p.link;
			Node temp=new Node();
			temp.data=num;
			temp.link=null;
			p.link=temp;
		}
	}

	/**
	 * if there are more than one nodes. 
	 * If node is head:
	 *    make temp as next element,
	 *    make it a previous node,
	 *    make it point to null.
	 *    move head to point to existing node,
	 *    and move p(temp head) move to next element
	 * else
	 *    make temp as next element,
	 *    move existing node point to previous node,
	 *    make existing node as previous node,
	 *    move head to point to existing node,
	 *    and move p(temp head) move to next element
	 * */
	public static void reverseLL(){
		Node prev=null;
		Node temp=null;
		Node p=head;

		if(head==null){
			System.out.println("Empty");
		}
		if(head.link==null){
			System.out.println("No change");
		}
		if(head.link!=null){
			while(p!=null){
				if(p==head){
					temp=p.link;
					prev=p;
					p.link=null;
					head=p;
					p=temp;
				}
				else{
					temp=p.link;
					p.link=prev;
					prev=p;
					head=p;
					p=temp;
				}
			}
		}
	}

	/**
	 * Keep on moving and displaying the data at p(temp head) till it reaches the end
	 * of the list.
	 * */
	public static void display(){
		Node p=head;
		System.out.println("Contents of Linked List");
		while(p!=null)
		{
			System.out.println(p.data);
			p=p.link;
		}
	}

	/**
	 * Main method to test the above methods.
	 * */
	public static void main(String[] args) {
		append(10);
		append(20);
		append(30);
		append(40);
		display();
		reverseLL();
		display();
	}
}
