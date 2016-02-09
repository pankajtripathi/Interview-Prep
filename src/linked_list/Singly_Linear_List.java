package linked_list;

/**
 * @author pankajtripathi
 * */
public class Singly_Linear_List{

	static Node head;
	public Singly_Linear_List(){
		head=null;
	}
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
	 * Add the node at start and make it as head.
	 * */
	public static void addAtBegin(int num){
		if(head==null){
			Node temp=new Node();
			temp.data=num;
			temp.link=null;
			head=temp;
		}
		else{
			Node temp=new Node();
			temp.data=num;
			temp.link=head;
			head=temp;
		}
	}
	/**
	 * Traverse to the mentioned position and then add the node the
	 * position mentioned.
	 * */
	public static void addAfter(int num,int pos){
		Node ref=head;
		for(int i=1;i<pos;i++){
			ref=ref.link;
		}
		Node temp=new Node();
		temp.data=num;
		temp.link=ref.link;
		ref.link=temp;
	}

	/**
	 * Traverse through list to find the element.
	 * If existing node has the data then
	 *    If the element is is at head then make it null.
	 *    else make the previous node point to next node of existing node
	 * else
	 *    make existing node as previous node.
	 * */
	public static void delete(int num){
		Node p=head,prev=null;
		while(p!=null){
			if(p.data==num){
				if(p==head){
					head=null;
				}
				else
					prev.link=p.link;		
			}
			else
				prev=p;
			p=p.link;
		}
	}

	/**
	 * Extreme conditions to check
	 * check if node is first node then move head ahead and return
	 * Move pointer p to position required for deletion
	 * if that position is last then make the previous point to null
	 * else make the previous point to next of existing node
	 * */
	public static void deleteAtPos(int pos) {
		Node p=head,prev=null;
		if(pos==1){
			head=p.link;
			return;
		}
		for(int i=1;i<pos;i++){
			prev=p;
			p=p.link;
		}
		if(p.link==null)
			prev.link=null;
		else{
			prev.link=p.link;
		}
	}
	/**
	 * Keep on moving and displaying the data at p(temp head) till it reaches the end
	 * of the list.
	 * */
	public static void display(){
		Node p=head;
		System.out.println("Contents of Linked List");
		while(p!=null){
			System.out.println(p.data);
			p=p.link;
		}
	}
	/**
	 * Keep on moving and taking the count of number of elements
	 * of the list.
	 * */
	public static int length() {
		Node p=head;
		int count=0;
		while(p!=null){
			p=p.link;
			count++;
		}
		return count;
	}
	/**
	 * Main method to test the above methods.
	 * */
	public static void main(String[] args) {
		addAtBegin(10);
		append(20);
		append(30);
		addAfter(15, 1);
		display();
		System.out.println("Number of elements: "+length());
		delete(15);
		display();
		deleteAtPos(1);
		display();
		deleteAtPos(2);
		display();
	}
}
