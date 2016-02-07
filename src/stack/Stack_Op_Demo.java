package stack;

public class Stack_Op_Demo {

	public static void main(String[] args) {

		Stack_Op obj=new Stack_Op();
		obj.push(10);
		obj.push(20);
		obj.push(30);
		obj.push(40);

		obj.display();

		System.out.println("After deletion");
		obj.pop();
		obj.display();
	}

}
