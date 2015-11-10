public class AddNumbers {

	/************************************************************************
	 * Numbers are in reverse: the digit at the unit's place is at the head of
	 * the list.
	 *************************************************************************/
	public static ListNode addNumbersInReverse(ListNode l1, ListNode l2) {

		ListNode first = l1;
		ListNode second = l2;

		ListNode falseHead = new ListNode(0);

		int sum = 0;
		int carry = 0;

		while ((first != null) && (second != null)) {

			sum = (first.val + second.val + carry) % 10;
			carry = (first.val + second.val + carry) / 10;

			falseHead.next = new ListNode(sum);
			falseHead = falseHead.next;
			first = first.next;
			second = second.next;
		}

		// for when one number has more digits than the other
		while (first != null) {
			sum = (first.val + carry) % 10;
			carry = (first.val + carry) / 10;
			falseHead.next = new ListNode(sum);
			falseHead = falseHead.next;
			first = first.next;
		}

		while (second != null) {
			sum = (second.val + carry) % 10;
			carry = (second.val + carry) / 10;
			falseHead.next = new ListNode(sum);
			falseHead = falseHead.next;
			second = second.next;
		}

		// If a carry remains, create new Node.
		if (carry != 0) {
			falseHead.next = new ListNode(carry);
		}
		return falseHead.next;

	}

	/************************************************************************
	 * Numbers are in correct order: the digit at the unit's place is at the end
	 * of the list.
	 *************************************************************************/
	
	public static ListNode addNumbers(ListNode first, ListNode second) {

		ListNode currentNodeFirst = first;
		ListNode currentNodeSecond = second;

		ListNode answerHead = null;
		ListNode previousAnswer = null;

		int sum = 0;
		int carry = 0;

		/*
		 * for when one number has more digits than the other. first find the
		 * length of both the lists. if one is greater than the other, pad
		 * zeroes
		 */

		int lengthFirst = 0;
		int lengthSecond = 0;
		while (currentNodeFirst != null) {
			lengthFirst++;
			currentNodeFirst = currentNodeFirst.next;
		}

		while (currentNodeSecond != null) {
			lengthSecond++;
			currentNodeSecond = currentNodeSecond.next;
		}

		int difference = lengthFirst - lengthSecond;
		if (difference > 0) {
			while (difference != 0) {
				// add 0 at beginning
				ListNode newHead = new ListNode(0);
				newHead.next = second;
				second = newHead;

				difference--;
			}
		} else if (difference < 0) {
			difference = -difference;
			while (difference != 0) {
				// add 0 at beginning
				ListNode newHead = new ListNode(0);
				newHead.next = first;
				first = newHead;

				difference--;
			}
		}

		currentNodeFirst = first;
		currentNodeSecond = second;

		/*
		 * Now do the same thing as the addNumbersReverse
		 */
		while ((currentNodeFirst != null) && (currentNodeSecond != null)) {

			sum = (currentNodeFirst.val + currentNodeSecond.val) % 10;
			carry = (currentNodeFirst.val + currentNodeSecond.val) / 10;

			if (answerHead == null) {
				answerHead = new ListNode(sum);
				previousAnswer = answerHead;
			} else {
				answerHead.addAtEnd(sum);
				previousAnswer.val = previousAnswer.val + carry;
				previousAnswer = previousAnswer.next;
			}

			currentNodeFirst = currentNodeFirst.next;
			currentNodeSecond = currentNodeSecond.next;
		}

		if (((first.val + second.val) / 10) > 0) {
			ListNode newAnswerHead = new ListNode((first.val + second.val) / 10);
			newAnswerHead.next = answerHead;
			answerHead = newAnswerHead;
		}

		return answerHead;

	}

	/***************************************************************************
	 * Testing
	 ***************************************************************************/

	public static void main(String[] args) {

		ListNode head1 = new ListNode(6);
		head1.addAtEnd(8);
		head1.addAtEnd(1);
		head1.addAtEnd(9);
		head1.print();

		ListNode head2 = new ListNode(2);
		head2.addAtEnd(9);
		head2.addAtEnd(9);
		head2.print();

		ListNode head = addNumbers(head1, head2);
		head.print();
	}
}
