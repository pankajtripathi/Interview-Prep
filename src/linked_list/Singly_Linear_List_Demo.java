package linked_list;

public class Singly_Linear_List_Demo {

	public static void main(String args[]){

		Singly_Linear_List n1=new Singly_Linear_List();

		n1.addAtBegin(40);
		n1.addAtBegin(30);
		n1.addAtBegin(20);
		n1.addAtBegin(10);

		n1.addAfter(25, 3);

		n1.display();
		n1.delete(30);
		n1.display();
		n1.delete(50);
	}
}
