package linked_list;

/**
 * @author pankajtripathi
 * */
public class DetectLoop {

	static Node head;
	static class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		DetectLoop list = new DetectLoop();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);
		// Creating a loop for testing 
		head.next.next.next.next.next = head.next.next;
		System.out.println("List has a loop? "+ list.detectLoop(head));
	}

	private String detectLoop(Node head) {
		Node fast=head,slow=head;
		while(slow!=null && fast!=null && fast.next!=null){
			slow=slow.next;
			fast=head.next.next;
			if(fast==slow)
				return "yes";
		}
		return "no";
	}
}
