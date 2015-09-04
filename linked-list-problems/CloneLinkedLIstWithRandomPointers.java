/*
 * You are given a Double Link List with one pointer of each node pointing to
 * the next node just like in a single link list. The second pointer however CAN
 * point to any node in the list and not just the previous node. Now write a
 * program in O(n) time to duplicate this list. That is, write a program which
 * will create a copy of this list.
 */
public class CloneLinkedLIstWithRandomPointers {

    public DoubleNode clone(DoubleNode head) {
	DoubleNode L1 = head;
	DoubleNode L2;

	while(L1 != null){
	    L2 = new DoubleNode(L1.data);
	    DoubleNode temp = L1;
	    L1 = L1.next;
	    temp.next = L2; 
	    L2= L2.next;
	}
	
	
	return null;
    }


}
