
public class MergeTwoSortedLinkedLists {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode one = l1;
		ListNode two = l2;

		//temporary head;
		ListNode head = new ListNode(0);
		ListNode current = head;

		while (one != null && two != null) {
			if (one.val <= two.val) {
				current.next = one;
				one = one.next;
			} else {
				current.next = two;
				two = two.next;
			}

			current = current.next;
		}

		if (one != null)
			current.next = one;
		if (two != null)
			current.next = two;

		return head.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(-9);
		l1.addAtEnd(-7);
		l1.addAtEnd(-3);
		l1.addAtEnd(-3);
		l1.addAtEnd(-1);
		l1.addAtEnd(2);
		l1.addAtEnd(3);

		ListNode l2 = new ListNode(-7);
		l2.addAtEnd(-7);
		l2.addAtEnd(-6);
		l2.addAtEnd(-6);
		l2.addAtEnd(-6);
		l2.addAtEnd(-3);
		l2.addAtEnd(2);
		l2.addAtEnd(4);

		ListNode head = mergeTwoLists(l1, l2);
		head.print();

	}
}
