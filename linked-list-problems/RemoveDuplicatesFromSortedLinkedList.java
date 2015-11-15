public class RemoveDuplicatesFromSortedLinkedList {

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		while (current != null) {
			if ((current.next != null) && current.val == current.next.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}

		}
		return head;
	}

	public static ListNode deleteDuplicates2(ListNode head) {
	
		ListNode prev = head;    
        ListNode curr = head.next;
 
        while(curr != null){
            if(curr.val == prev.val){
                prev.next = curr.next;
                curr = curr.next; //do not change prev
            }else{
                prev = curr;
                curr = curr.next; 
            }
        }
 
		return head;
	}

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.addAtEnd(2);
		head.addAtEnd(2);
		head.addAtEnd(3);
		head.addAtEnd(4);
		head.addAtEnd(4);
		head.addAtEnd(4);
		head.addAtEnd(5);
		head.addAtEnd(6);
		head.addAtEnd(6);

		// deleteDuplicates(head);
		deleteDuplicates2(head);

		head.print();

	}
}
