 import java.util.HashSet;
import java.util.Set;

public class MergeSortedPostingsLists {

	public static void merge(Set<Integer> set, ListNode head1, ListNode head2) {
		
		while(head1 != null && head2!= null) {
			if(head1.val == head2.val){
				set.add(head1.val);
				head1 = head1.next;
				head2 = head2.next;
			}else if (head1.val > head2.val){
				head2 = head2.next;
			}else{
				head1 = head1.next;
			}
		}
	}
	
	private static ListNode createPostingList1(){
        ListNode head = new ListNode(1);
        head.addAtEnd(2);
        head.addAtEnd(3);
        head.addAtEnd(5);
        head.addAtEnd(8);
        head.addAtEnd(13);
        head.addAtEnd(21);
        head.addAtEnd(34);
        return head;

	}
	
	private static ListNode createPostingList2(){
        ListNode head = new ListNode(2);
        head.addAtEnd(4);
        head.addAtEnd(8);
        head.addAtEnd(16);
        head.addAtEnd(32);
        head.addAtEnd(64);
        head.addAtEnd(128);
        return head;
	}
		
	public static void main (String[] args) {
		
		ListNode head1 = createPostingList1();
		ListNode head2 = createPostingList2();

		Set<Integer> set = new HashSet<>();

		merge(set, head1, head2);
		
		for(int i : set) {
			System.out.println(i);
		}
	}
}
