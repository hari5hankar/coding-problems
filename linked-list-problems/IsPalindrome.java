
import java.util.Stack;

public class IsPalindrome {

	public static boolean isPalindrome(ListNode head) {

		Stack<Integer> stack = new Stack<Integer>();
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null) {
			stack.push(slow.val);
			slow = slow.next;
			if (fast.next != null)
				fast = fast.next.next;
			else
				break;
		}

		// if here fast.next = null, means list has odd number of elements.
		if (fast != null && fast.next == null)
			stack.pop(); // so pop the stack which contains middle element.

		//slow always points to the element after the middle
		while (!stack.isEmpty()) {
			if (stack.pop() != slow.val) {
				return false;
			}
			slow = slow.next;
		}

		return true;

	}

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.addAtEnd(2);
		head.addAtEnd(3);
		head.addAtEnd(4);
		head.addAtEnd(5);
		head.addAtEnd(4);
		head.addAtEnd(3);
		head.addAtEnd(2);
		head.addAtEnd(1);
		/*
		 * head.addAtEnd(2); head.addAtEnd(1);
		 */

		System.out.println(isPalindrome(head));
	}
}
