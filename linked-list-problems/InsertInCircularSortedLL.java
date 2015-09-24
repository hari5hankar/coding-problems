
public class InsertInCircularSortedLL {

	public static Node insert(Node head, int num) {
		Node node = new Node(num);
		if (head == null) {
			node.next = node;
			return node;
		}
		Node current = head;
		while (true) {
			if (current.next.data >= num) {
				if (current == head) {
					node.next = head;
					while (current.next != head)
						current = current.next;
					current.next = node;
					return node;
				} else if (current.next == head) {
					current.next = node;
					node.next = head;
					return head;
				} else {
					Node temp = current.next;
					current.next = node;
					node.next = temp;
					return head;
				}
			}

			current = current.next;
			if (current.next == head) {
				current.next = node;
				node.next = head;
				return head;
			}
		}
	}
	
	public static void print(Node head) {
		Node current = head;
		while(current.next != head) {
			System.out.print(current.data +  "->");
			current = current.next;
		}
		System.out.print(current.data);
		System.out.println();
	}

	public static void main(String[] args) {
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(6);
		head.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next = head;
		print(head);	

		head = insert(head, 5);
		print(head);
		head = insert(head, 0);
		print(head);
		head = insert(head, 8);
		print(head);
		
	}

}
