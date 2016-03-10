package queue;

/**
 * @author pankajtripathi
 * */
public class Queue_Array_Demo {

	public static void main(String[] args) {
		Queue_Array obj=new Queue_Array();

		obj.insert(23);
		obj.insert(204);
		obj.insert(12);
		obj.insert(22);
		obj.delete();
		obj.display();
	}

}
