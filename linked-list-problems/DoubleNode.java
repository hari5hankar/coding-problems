import java.util.ArrayList;

public class DoubleNode {
    public int data;
    public DoubleNode next;
    public DoubleNode prev;

    public DoubleNode(int data) {
	this.data = data;
    }

    public void addAtEnd(int data) {

	DoubleNode newLast = new DoubleNode(data);
	DoubleNode currentNode = this;

	while (currentNode.next != null) {
	    currentNode = currentNode.next;
	}
	currentNode.next = newLast;
	newLast.prev = currentNode;
    }

    public void print() {
	DoubleNode currentDoubleNode = this;
	while (currentDoubleNode != null) {
	    System.out.print(currentDoubleNode.data + "<->");
	    currentDoubleNode = currentDoubleNode.next;
	}
	System.out.println("//");
    }

    public static DoubleNode createDoublyLinkedList() {

	DoubleNode head = new DoubleNode(0);
	for (int i = 1; i < 5; i++) {
	    head.addAtEnd(i);
	}
	return head;
    }
    
    public static DoubleNode createDoublyRandomLinkedList(int size) {
	
	ArrayList<DoubleNode> list = new ArrayList<>();
	DoubleNode head = new DoubleNode(0);
	list.add(head);
	DoubleNode prevNode = list.get(0);
	for(int i = 1; i<size; i++){
	    list.add(new DoubleNode(i));
	    prevNode.next = list.get(i); 
	    prevNode = prevNode.next;
	}
	
	for(int i = 0; i< size; i++){
	    int rand = (int) (Math.random()*10);
	    list.get(i).prev = list.get(rand);
	}
	
	return head;
    }

    public static void main(String[] args) {
	DoubleNode dn = createDoublyRandomLinkedList(5);
	dn.print();
    }

}
