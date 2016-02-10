package linked_list;

public class SwapNodes {

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
	 * @param x y two nodes to be swapped
	 * return if both are same nodes
	 * keep iterating the list to find previous of x and position of x
	 * repeat same procedure for y
	 * check if previous of x or y is head node...if x is head node then make y as new head and vice versa
	 * else make previous of x or y point to current y or current x respectively.
	 * later swap the next nodes of x and y
	 *  
	 * */
	public static void swapNodes(int x,int y){
		// Nothing to do if x and y are same
		if(x==y)return;
		
		// Search for x (keep track of prev_x and curr_x)
		Node curr_x=head,prev_x=null;
		while(curr_x!=null&&curr_x.data!=x){
			prev_x=curr_x;
			curr_x=curr_x.link;
		}
		// Search for x (keep track of prev_y and curr_y)
		Node curr_y=head,prev_y=null;
		while(curr_y!=null&&curr_y.data!=y){
			prev_y=curr_y;
			curr_y=curr_y.link;
		}
		// If either x or y is not present, nothing to do
		if(curr_x==null||curr_y==null)
			return;
		
		//Check if x is head node
		if(prev_x!=null)
			prev_x.link=curr_y;
		else
			head=curr_y;
		
		//Check if y is head node
		if(prev_y!=null)
			prev_y.link=curr_x;
		else
			head=curr_x;

		//swap next of the x and y node
		Node temp=curr_x.link;
		curr_x.link=curr_y.link;
		curr_y.link=temp;
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
	 * Main method to test above methods
	 * */
	public static void main(String[] args) {
		append(10);
		append(20);
		append(30);
		append(15);
		append(50);
		display();
		swapNodes(15,20);
		display();
		swapNodes(10, 30);
		display();
		swapNodes(20, 50);
		display();
	}
}
