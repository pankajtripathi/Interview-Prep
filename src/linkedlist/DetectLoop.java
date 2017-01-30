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
        if(head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head.next;
        
        while(slow != fast){
            if(fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
		return "yes";
	}
}
