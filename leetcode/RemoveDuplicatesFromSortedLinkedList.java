public class RemoveDuplicatesFromSortedLinkedList {

	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		
		ListNode current = head;
		while(current!= null){
			if(current.next != null && current.val == current.next.val){
				current.val = current.next.val;
				current.next = current.next.next;
			}
			current = current.next;
		}
		
		return head;
	}
}
