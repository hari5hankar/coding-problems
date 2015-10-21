
/**
 * Created by Harishankar on 25-06-2015.
 */
public class CircularLinkedList {

    public static ListNode detectlLoopInLinkedList(ListNode head){

        ListNode fastNode = head;
        ListNode slowNode = head;

        /*
         *  use a fast pointer and a slow pointer,
         *  the fast pointer traverses the list twice as fast.
         *  the node they meet at is at the same distance from
         *  the start of the loop as is the head node.
         */

        /*
         * Note: cannot use
         * while(slowNode != fastNode)
         * here, as we may NOT have a loop as well.
         */

        while(slowNode.next!= null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;

            if(fastNode == slowNode){
                break;
            }
        }


        /*
         * No loop was detected
         */

        if(slowNode.next == null){
            return null;
        }


        slowNode = head;
        while(slowNode.next!= null){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if(slowNode == fastNode){
                break;
            }
        }


        return slowNode;
    }

    public static void main(String[] args){

        ListNode head = ListNode.createLinkedList();
        head.print();

        ListNode endOfList = head;
        while(endOfList.next != null){
            endOfList = endOfList.next;
        }

        endOfList.next = head.next.next.next;

        ListNode startOfLoop = detectlLoopInLinkedList(head);
        if(startOfLoop != null) {
            System.out.println(startOfLoop.val);
        }

    }

}
