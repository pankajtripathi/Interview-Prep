package linked_list;

public class Reverse {

	static Node head=null;

	public static void addAtBegin(int num){
		if(head==null)
		{
			Node temp=new Node();
			temp.data=num;
			temp.link=null;
			head=temp;
		}
		else
		{
			Node temp=new Node();
			temp.data=num;
			temp.link=head;
			head=temp;
		}
	}

	public static void reverseLL(){
		Node r=null;
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
					r=p;
					p.link=null;
					head=p;
					p=temp;
				}
				else
				{   
					temp=p.link;
					p.link=r;
					r=p;
					head=p;
					p=temp;
				}

			}
		}

	}

	public static void display(){

		Node p=head;
		System.out.println("Contents of Linked List");
		while(p!=null)
		{
			System.out.println(p.data);
			p=p.link;
		}
	}

	public static void main(String[] args) {

		addAtBegin(640);
		addAtBegin(530);
		addAtBegin(420); 
		addAtBegin(340);
		addAtBegin(230);
		addAtBegin(120); 
		display();
		reverseLL();
		display();

	}

}
