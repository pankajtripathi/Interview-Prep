package queue;

import java.util.Scanner;

public class Queue_Array {

	int rear=-1;
	int front=-1;
	int a[],max;
	Scanner s=new Scanner(System.in);

	Queue_Array(){
		System.out.println("Enter size of array");
		max=s.nextInt();
		a=new int[max];
	}

	void insert(int data){
		if(rear==max-1){
			System.out.println("Queue is full");
		}
		else{
			rear=rear+1;
			a[rear]=data;
		}
	}

	int delete()
	{
		if(front==rear){

			System.out.println("Queue is empty");
			return 0;

		}
		else{

			front=front+1;
			return(a[front]);
		}
	}

	void display()
	{
		System.out.println("Queue contents:");
		for(int i=front; i<=rear; i++)
			System.out.println(a[i]);

	}
}
