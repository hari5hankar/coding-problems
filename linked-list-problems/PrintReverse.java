
public class PrintReverse {

	public static void printReverse(ListNode head){
		if(head == null){
			return;
		}
		printReverse(head.next);
		System.out.print(head.val + "<-");
	}
	
	public static void main(String[] args) {
		ListNode head = ListNode.createLinkedList2();
		printReverse(head);
	}
}
