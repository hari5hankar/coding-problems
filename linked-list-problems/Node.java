
/**
 * Created by Harishankar on 17-06-2015.
 */

  public class Node {
      public int data;
      public Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public void addAtEnd(int data) {

        Node newLast = new Node(data);
        Node currentNode = this;

        while(currentNode.next != null)	{
            currentNode = currentNode.next;
        }
        currentNode.next = newLast;
    }

    public void print(){
        Node currentNode = this;
        while(currentNode!= null){
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }
        System.out.println("//");
    }

    public static Node createLinkedList(){

        Node head = new Node(1);
        head.addAtEnd(4);
        head.addAtEnd(2);
        head.addAtEnd(3);
        head.addAtEnd(4);
        head.addAtEnd(4);
        head.addAtEnd(2);
        head.addAtEnd(2);
        head.addAtEnd(4);
        head.addAtEnd(3);

        return head;
    }

    public static void main(String[] args) {
		Node head = createLinkedList();
		head.print();
	}
  }
