
public class InsertInCircularSortedLL {

	public static ListNode insert(ListNode head, int num) {
		ListNode node = new ListNode(num);
		if (head == null) {
			node.next = node;
			return node;
		}
		ListNode current = head;
		while (true) {
			if (current.next.val >= num) {
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
					ListNode temp = current.next;
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
	
	public static void print(ListNode head) {
		ListNode current = head;
		while(current.next != head) {
			System.out.print(current.val +  "->");
			current = current.next;
		}
		System.out.print(current.val);
		System.out.println();
	}

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next = new ListNode(7);
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
