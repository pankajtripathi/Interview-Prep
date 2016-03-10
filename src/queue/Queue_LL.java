package queue;

/**
 * @author pankajtripathi
 * */
public class Queue_LL {

	Node front,rear;
	Queue_LL(){

		front=null;
		rear=null;
	}

	void Qinsert(int num){

		if(rear==null){

			Node temp=new Node();
			temp.data=num;
			temp.link=null;
			front=rear=temp;
		}
		else{

			Node temp=new Node();
			temp.data=num;
			temp.link=null;
			rear.link=temp;
			rear=temp;
		}
	}

	int Qdelete(){

		int n=0;
		if(front==rear)
			System.out.println("Empty Queue");
		else
		{

			if(front.link==null){
				n=front.data;
				front=rear=null;

			}
			else
			{
				Node temp=front;
				n=front.data;
				front=front.link;
				temp=null;
			}
		}
		return n;
	}

	void display(){
		Node p=front;

		System.out.println("Queue contents:");

		while(p!=null){
			System.out.println(p.data);
			p=p.link;
		}
	}

}
