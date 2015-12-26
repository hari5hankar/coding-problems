
public class DeleteAllInstances {

	static ListNode deleteAllInstances(ListNode head, int data) {
	    if(head == null) return null;
	    
	    ListNode tempHead = new ListNode(0);
	    tempHead.next = head;
	    
	    ListNode curr = tempHead;
	    while(curr != null){
	     ListNode a = curr.next;
	        while(a!= null && a.val == data){ 
	            a = a.next;
	         }
	    curr.next = a;  
	    curr = curr.next;
	    }
	    
	    return tempHead.next;
	}
	
	public static void main(String[] args) {
		//3-->3-->5 --> 3 --> 7 --> 3

		ListNode head = new ListNode(3);
		head.next = new ListNode(3);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next = new ListNode(3);
		
		ListNode.print(head);
		
		ListNode ret = DeleteAllInstances.deleteAllInstances(head, 3);
		ListNode.print(ret);
	}
	
}
