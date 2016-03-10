package queue;

/**
 * @author pankajtripathi
 * */
public class QueueLL_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue_LL obj=new Queue_LL();

		obj.Qinsert(10);
		obj.Qinsert(20);
		obj.Qinsert(30);
		obj.Qinsert(40);

		obj.display();

		obj.Qdelete();

		obj.display();
	}

}
