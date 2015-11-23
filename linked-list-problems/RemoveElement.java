
public class RemoveElement {
	public static ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        
        ListNode falseHead = new ListNode(0);
        falseHead.next = head;
        ListNode current = falseHead;
        while(current.next != null){
            if(current.next.val == val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        
        return falseHead.next;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		System.out.println(removeElements(head, 1));
	}
}
