
public class MiddleOfList {

	public static ListNode middle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;

		while (fast != null) {
			prev = slow;
			slow = slow.next;
			if (fast.next != null)
				fast = fast.next.next;
			else
				break;
		}

		// In both odd and even cases, return prev.
		return prev;
	}

	/***************************************************************************
	 * Testing
	 ***************************************************************************/
	public static void main(String[] args) {
		ListNode head = ListNode.createLinkedList2();
		head.next.next.next.next.next.next.next.next = null;
		head.print();
		head = middle(head);
		head.print();
	}
}
