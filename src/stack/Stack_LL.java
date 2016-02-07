package stack;

public class Stack_LL {

	static Node top;
	Stack_LL()
	{
		top=null;	
	}

	static void push(int num){
		Node temp=new Node();
		temp.data=num;
		temp.link=top;
		top=temp;
	}

	static int pop(){
		if(top==null){
			System.out.println("Stack is empty");
			return 0;
		}
		else
		{
			int n=top.data;
			top=top.link;
			return n;
		}
	}

	static void display(){
		Node p=top;
		System.out.println("Contents of StackList:");
		while(p!=null){
			System.out.println(p.data);
			p=p.link;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		push(10);
		push(20);
		push(30);
		push(40);
		display();
		pop();
		display();
	}

}
