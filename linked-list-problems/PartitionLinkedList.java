
/**
 * Created by Harishankar on 22-06-2015.
 */
public class PartitionLinkedList {

	/*
	 * create two new linked lists, one for every node who's value is less than
	 * given Node other for every node who's value is greater that given Node
	 * join the two lists together
	 */

	public static ListNode partitionLinkedList_1(ListNode head, int partitionValue) {

		//false head nodes of new lists
		ListNode small = new ListNode(0); 
		ListNode large = new ListNode(0);
		
		//saving temporarily.
		ListNode smallStart = small;
		ListNode largeStart = large;		
		ListNode smallLast = null;

		ListNode curr = head;
		while (curr.next != null) {
			if (curr.val < partitionValue) {
				small.next = new ListNode(curr.val);
				smallLast = small;
				small = small.next;
			} else {
				large = new ListNode(curr.val);
				large = large.next;
			}
			curr = curr.next;
		}
		
		smallLast.next = largeStart.next;
		return smallStart.next;
	}

	/***************************************************************************
	 * Testing
	 ***************************************************************************/
	public static void main(String[] args) {

		ListNode head = ListNode.createLinkedList();
		head.print();
		head = partitionLinkedList_1(head, 3);
		head.print();

	}
}
