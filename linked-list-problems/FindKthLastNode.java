
public class FindKthLastNode {

	/***************************************************************************
	 * Iterative solution 1: Traverse linked list to find size N. Then traverse
	 * again to get the (N - k)th node from beginning
	 * 
	 ***************************************************************************/

	public static ListNode findKthLastNode_1(ListNode head, int k) {

		int N = 0; // size of linked list
		ListNode currentNode = head;

		while (currentNode != null) {
			currentNode = currentNode.next;
			N++;
		}

		System.out.println(N - k + 1);

		// should take N - k jumps from head to reach kth last node.
		ListNode kthlast = head;
		for (int i = 0; i < N - k; i++)
			kthlast = kthlast.next;

		return kthlast;
	}

	/***************************************************************************
	 * Iterative solution 2: Traverse and reach kth node of the list. Now
	 * initialize another pointer at head. Move both the pointers
	 * simultaneously, till the first pointer reaches the tail. The second
	 * pointer now points to the kth last node.
	 ***************************************************************************/

	public static ListNode findKthLastNode_5(ListNode head, int k) {
		ListNode temp = head;

		// to reach the kth node, make k-1 jumps form head.
		for (int i = 0; i < k - 1; i++)
			temp = temp.next;
		ListNode current = head;
		while (temp.next != null) {
			current = current.next;
			temp = temp.next;
		}

		return current;
	}

	/***************************************************************************
	 * Recursive solution 1 (easy): Recurse till you get to the end of the list.
	 * Keep adding 1 to what you get. If value == k, this is your Node.
	 ***************************************************************************/

	public static int findKthLastNode_2(ListNode head, int k) {

		if (head == null) {
			return 0;
		}
		int value = findKthLastNode_2(head.next, k) + 1;
		if (value == k) {
			System.out.println(head.val);
		}
		return value;

	}

	class ListNodeWrapper {
		ListNode node;
		int indexFromLast;

		public ListNodeWrapper(ListNode node, int indexFromLast) {
			this.node = node;
			this.indexFromLast = indexFromLast;
		}

	}

	/***************************************************************************
	 * Recursive solution 2: When end is reached, return a counter set to 0.
	 * Each parent call adds 1 to the counter When counter == k, we have reached
	 * Kth last element.
	 ***************************************************************************/

	static class IntegerWrapper {
		int index;

		IntegerWrapper(int value) {
			this.index = value;
		}
	}

	public static ListNode findKthLastNode_3(ListNode head, int k) {
		return findKthLastNode_3(head, k, new IntegerWrapper(0));
	}

	// Helper
	private static ListNode findKthLastNode_3(ListNode head, int k, IntegerWrapper i) {

		if (head == null) {
			return null;
		}

		// keep returning the curr (which will be null until when i = k). when
		// i == k start returning the head node for that method call.
		ListNode curr = findKthLastNode_3(head.next, k, i);
		i.index += 1;
		if (i.index == k)
			return head;
		else
			return curr;
	}

	/***************************************************************************
	 * alternate solution uses a wrapper for the whole node, rather than just an
	 * Integer.
	 ***************************************************************************/

	static class NodeWrapper {
		ListNode node;
		int indexFromEnd; // indexFromEnd in linked list from the end

		NodeWrapper(ListNode node, int index) {
			this.node = node;
			this.indexFromEnd = index;
		}
	}

	public static ListNode findKthLastNode_4(ListNode head, int k) {
		// need to pass return a Node and a counter
		NodeWrapper kthLastNode = findKthLastNode_4(new NodeWrapper(head, -1), k);
		return kthLastNode.node;

	}

	// Helper
	public static NodeWrapper findKthLastNode_4(NodeWrapper headNW, int k) {

		if (headNW.node == null) {
			return new NodeWrapper(null, 0);
		}

		NodeWrapper currentNW = findKthLastNode_4(new NodeWrapper(headNW.node.next, -1), k);
		headNW.indexFromEnd = currentNW.indexFromEnd + 1;
		if (currentNW.indexFromEnd == k) {
			return currentNW;
		} else {
			return headNW;
		}
	}

	/***************************************************************************
	 * Testing
	 ***************************************************************************/

	public static void main(String[] args) {
		ListNode head = ListNode.createLinkedList2();
		head.print();
		// findKthLastNode_1(head, 6).print();
		// findKthLastNode_2(head, 6);
		findKthLastNode_3(head, 6).print();
		// findKthLastNode_4(head, 6).print();
		// findKthLastNode_5(head, 6).print();
	}

}
