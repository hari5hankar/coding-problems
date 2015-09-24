import java.util.HashSet;
import java.util.Set;

public class MergeSortedPostingsLists {

	public static void merge(Set<Integer> set, Node head1, Node head2) {
		
		while(head1 != null && head2!= null) {
			if(head1.data == head2.data){
				set.add(head1.data);
				head1 = head1.next;
				head2 = head2.next;
			}else if (head1.data > head2.data){
				head2 = head2.next;
			}else{
				head1 = head1.next;
			}
		}
	}
	
	private static Node createPostingList1(){
        Node head = new Node(1);
        head.addAtEnd(2);
        head.addAtEnd(3);
        head.addAtEnd(5);
        head.addAtEnd(8);
        head.addAtEnd(13);
        head.addAtEnd(21);
        head.addAtEnd(34);
        return head;

	}
	
	private static Node createPostingList2(){
        Node head = new Node(2);
        head.addAtEnd(4);
        head.addAtEnd(8);
        head.addAtEnd(16);
        head.addAtEnd(32);
        head.addAtEnd(64);
        head.addAtEnd(128);
        return head;
	}
		
	public static void main (String[] args) {
		
		Node head1 = createPostingList1();
		Node head2 = createPostingList2();

		Set<Integer> set = new HashSet<>();

		merge(set, head1, head2);
		
		for(int i : set) {
			System.out.println(i);
		}
	}
}
