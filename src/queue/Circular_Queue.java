package queue;

import java.util.Scanner;

public class Circular_Queue {

	int front,rear,size;
	int a[];
	Scanner s=new Scanner(System.in);

	Circular_Queue(){
		System.out.println("Enter the size of queue");
		size=s.nextInt();
		a=new int[size];
		front=rear=-1; 
	}

	void CQinsert(int num){

		if(front == (rear+1)% size)
			System.out.println("Queue is full");
		else
		{
			if(front==-1)
				front=rear=0;
			else
				rear=(rear+1)% size;
			a[rear]=num;
		}
	}

	int CQdelete(){

		int n;
		if(front==-1){
			System.out.println("Queue is empty");
			return 0;
		}
		else
		{   n=a[front];

		if(front==rear)
			front=rear=-1;

		front=(front+1)% size;
		}
		return n;
	}

	void display(){
		if(front == -1)
			System.out.println("Queue is empty");
		else{

			System.out.println("Contents of Queue");
			for(int i=front;i<=rear;i++)
			{
				System.out.println(a[i]+" ");
			}
		}
	}
}
