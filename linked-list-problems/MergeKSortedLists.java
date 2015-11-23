import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	public static ListNode mergeKSortedLists(ListNode[] lists) {

		if (lists == null || lists.length == 0)
			return null;

		class NaturalOrder implements Comparator<ListNode> {
			@Override
			public int compare(ListNode l1, ListNode l2) {
				if (l1.val > l2.val)
					return 1;
				else if (l1.val < l2.val)
					return -1;
				else
					return 0;
			}
		}

		PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new NaturalOrder());

		for (ListNode headNode : lists) {
			if (headNode != null)
				pq.add(headNode);
		}

		ListNode head = new ListNode(0);
		ListNode current = head;

		while (!pq.isEmpty()) {
			ListNode temp = pq.poll();
			current.next = temp;
			current = current.next;

			if (temp.next != null)
				pq.add(temp.next);
		}

		return head.next;

	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(-9);
		l1.addAtEnd(-7);
		l1.addAtEnd(-3);
		l1.addAtEnd(-3);
		l1.addAtEnd(-1);
		l1.addAtEnd(2);
		l1.addAtEnd(3);

		ListNode l2 = new ListNode(-7);
		l2.addAtEnd(-7);
		l2.addAtEnd(-6);
		l2.addAtEnd(-6);
		l2.addAtEnd(-6);
		l2.addAtEnd(-3);
		l2.addAtEnd(2);
		l2.addAtEnd(4);

		ListNode l3 = new ListNode(-4);
		l3.addAtEnd(-1);
		l3.addAtEnd(-1);
		l3.addAtEnd(0);
		l3.addAtEnd(1);
		l3.addAtEnd(2);
		l3.addAtEnd(3);
		l3.addAtEnd(4);

		List<ListNode> list = new ArrayList<>();
		list.add(l1);
		list.add(l2);
		list.add(l3);

		ListNode head = mergeKSortedLists(new ListNode[0]);
		head.print();
	}

}
