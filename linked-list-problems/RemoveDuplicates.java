
import java.util.HashSet;

public class RemoveDuplicates {

    /******************************************************************
     *  Use a hash set.
     *******************************************************************/
    public static ListNode removeDuplicates(ListNode head) {

        HashSet<Integer> set = new HashSet<>();
        ListNode currentNode = head;
        ListNode previousNode = null;

        while(currentNode!= null){
          if(set.contains(currentNode.val)){
              previousNode.next = currentNode.next;
          }else {
              set.add(currentNode.val);
              previousNode = currentNode;
          }
            currentNode = currentNode.next;
        }
      return head;
    }

    /******************************************************************
     *  Without using a temporary buffer
     *******************************************************************/

    public static ListNode removeDuplicatesWithoutBuffer(ListNode head){
        ListNode currentPrimaryNode = head;

        while(currentPrimaryNode !=null) {
            ListNode currentSecondaryNode = currentPrimaryNode.next;
            ListNode previousSecondaryNode = currentPrimaryNode;
            while (currentSecondaryNode != null) {
                if (currentSecondaryNode.val == currentPrimaryNode.val) {
                    previousSecondaryNode.next = currentSecondaryNode.next;
                }
                previousSecondaryNode = currentSecondaryNode;
                currentSecondaryNode = currentSecondaryNode.next;
            }
            currentPrimaryNode = currentPrimaryNode.next;
        }

        return head;
    }

    //------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {

        ListNode head = ListNode.createLinkedList();
        head.print();
        head = removeDuplicates(head);
        head.print();

        head = ListNode.createLinkedList();
        head.print();
        head = removeDuplicatesWithoutBuffer(head);
        head.print();
    }
}
