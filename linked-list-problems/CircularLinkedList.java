public class CircularLinkedList {

	/***************************************************************************
	 * use a fast pointer and a slow pointer, the fast pointer traverses the
	 * list twice as fast. the node they meet at is at the same distance from
	 * the start of the loop as is the head node.
	 ***************************************************************************/
	
	public static ListNode detectlLoopInLinkedList(ListNode head) {

		ListNode fast = head;
		ListNode slow = head;
		ListNode loop = null;

		while (true) {
			slow = slow.next;
			if (fast.next != null)
				fast = fast.next.next;
			else
				break; //no loop

			if (slow == null || fast == null)
				break; //no loop

			if (slow == fast) {
				loop = slow;
				break; //loop detected
			}
		}

		// no loop detected
		if (loop == null)
			return null;

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

	public static void main(String[] args) {

		ListNode head = ListNode.createLinkedList();
		head.print();

		ListNode endOfList = head;
		while (endOfList.next != null) {
			endOfList = endOfList.next;
		}

		endOfList.next = head.next.next.next;

		ListNode startOfLoop = detectlLoopInLinkedList(head);
		if (startOfLoop != null) {
			System.out.println(startOfLoop.val);
		}

	}

}
