
  public class ListNode {
      public int val;
      public ListNode next;

    public ListNode(int data){
        this.val = data;
        this.next = null;
    }

    public void addAtEnd(int data) {

        ListNode newLast = new ListNode(data);
        ListNode currentNode = this;

        while(currentNode.next != null)	{
            currentNode = currentNode.next;
        }
        currentNode.next = newLast;
    }

    public void print(){
        ListNode currentNode = this;
        while(currentNode!= null){
            System.out.print(currentNode.val + "->");
            currentNode = currentNode.next;
        }
        System.out.println("//");
    }
    
    public String toString(){
    	return Integer.toString(this.val);
    }

    public static ListNode createLinkedList(){

        ListNode head = new ListNode(1);
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
    
    public static ListNode createLinkedList2(){

        ListNode head = new ListNode(1);
        head.addAtEnd(2);
        head.addAtEnd(3);
        head.addAtEnd(4);
        head.addAtEnd(5);
        head.addAtEnd(6);
        head.addAtEnd(7);
        head.addAtEnd(8);
        head.addAtEnd(9);
        return head;
    }

    public static void main(String[] args) {
		ListNode head = createLinkedList();
		head.print();
	}
  }
