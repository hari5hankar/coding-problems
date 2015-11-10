public class ReverseLinkedList {

	public static ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode lo = head;
		ListNode mid = head.next;
		ListNode hi = head.next.next;

		while (hi != null) {
			mid.next = lo;
			lo = mid;
			mid = hi;
			hi = hi.next;
		}
		mid.next = lo;
		head.next = null;
		return mid;
	}

	public static ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode first = head;
		ListNode second = head.next;

		while (second != null) {
			ListNode third = second.next;
			second.next = first;
			first = second;
			second = third;
		}
		head.next = null;
		return first;

	}

	public static ListNode recursiveReverse(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// get second node
		ListNode second = head.next;
		// set first's next to be null
		head.next = null;

		ListNode rest = reverseList(second);
		second.next = head;

		return rest;
	}

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.addAtEnd(2);

		head.print();
		head = reverseList2(head);
		head.print();
		
		
	}

}
