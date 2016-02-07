package linked_list;

public class Singly_Linear_List{

	Node head;

	public Singly_Linear_List(){

		head=null;
	}
	public void addAtBegin(int num){
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
	public void addAfter(int num,int pos){

		Node ref=head;
		for(int i=1;i<pos;i++)
		{
			ref=ref.link;
		}
		Node temp=new Node();
		temp.data=num;
		temp.link=ref.link;
		ref.link=temp;
	}

	public void delete(int num){
		Node p=head;
		Node old=null;
		boolean b=false;

		if(head==null)
			System.out.println("Empty List");
		if(head.link==null && head.data==num)
		{
			b=true;
			head=null;
		}
		if(head.link!=null && head.data==num)
		{
			b=true;
			head=head.link;
		}
		while(p!=null)
		{
			if(p.data==num){
				b=true;
				old.link=p.link;
				p=null;
			}
			else{
				old=p;
				p=p.link;
			}
		}
		if(b)
			System.out.println(num +" is deleted");
		else
			System.out.println(num +" not found in the list");
	}
	public void display(){

		Node p=head;
		System.out.println("Contents of Linked List");
		while(p!=null)
		{
			System.out.println(p.data);
			p=p.link;
		}
	}
}
