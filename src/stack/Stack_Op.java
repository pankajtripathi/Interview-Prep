package stack;

import java.util.Scanner;

public class Stack_Op {

	int max,top;
	Scanner scan=new Scanner(System.in);
	int s[];

	Stack_Op()
	{
		System.out.println("Enter the capacity of stack");
		max=scan.nextInt();
		s=new int[max];
		top = -1;
	}

	void push(int num)
	{
		if(top == (max-1))
			System.out.println("Stack is full");
		else
		{
			s[++top]=num;
		}
	} 

	int pop()
	{
		if(top==-1)
		{
			System.out.println("Stack is empty");
			return 0;
		}
		else
		{
			return s[top--];
		}
	}

	boolean isEmpty()
	{
		if(top==-1)
			return true;
		else
			return false;
	}

	boolean isFull()
	{
		if(top==max-1)
			return true;
		else
			return false;
	}

	void display()
	{
		if(top==-1)
			System.out.println("Stack is empty");
		else{
			System.out.println("Contents of stack");

			for(int i=top;i>=0;i--)
				System.out.println(s[i]);
		}

	}
}
