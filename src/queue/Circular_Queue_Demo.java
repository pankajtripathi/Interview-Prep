package queue;

/**
 * @author pankajtripathi
 * */
public class Circular_Queue_Demo {

	public static void main(String[] args) {

		Circular_Queue obj=new Circular_Queue();

		obj.CQinsert(23);
		obj.CQinsert(204);
		obj.CQinsert(12);
		obj.display();
		System.out.println("Element deleted"+obj.CQdelete());	       
		obj.display();
	}
}
