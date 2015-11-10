
public class MiddleOfList {

	public static ListNode middle(ListNode head){
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;
		
		while(fast!= null && fast.next != null){
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		
		if(fast == null) return prev;
		else return slow;
	}
	
	public static void main(String[] args) {
		ListNode head = ListNode.createLinkedList();
		head.print();
		head = middle(head);
		head.print();
	}
}
