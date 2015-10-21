
/**
 * Created by Harishankar on 22-06-2015.
 */
public class DeleteNode {

    public static void deleteNode(ListNode someNode){

        ListNode currentNode = someNode;
        while( (currentNode.next.next) != null){
            ListNode nextNode = currentNode.next;
            currentNode.val = nextNode.val;
            currentNode = nextNode;
        }
         currentNode.next = null;
    }

    public static void deleteNode_2(ListNode someNode){

        ListNode nextNode = someNode;
        nextNode.val = nextNode.next.val;
        nextNode.next = nextNode.next.next;

    }

    public static void main(String[] args){
        ListNode head = ListNode.createLinkedList();
        head.print();
        deleteNode(head.next.next.next);
        head.print();

        head = ListNode.createLinkedList();
        head.print();
        deleteNode_2(head.next.next.next);
        head.print();
    }
}
