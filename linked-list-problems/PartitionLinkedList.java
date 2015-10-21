
/**
 * Created by Harishankar on 22-06-2015.
 */
public class PartitionLinkedList {

     /*
      * create two new linked lists,
      * one for every node who's value is less than given Node
      * other for every node who's value is greater that given Node
      * join the two lists together
      */

    public static ListNode partitionLinkedList_1(ListNode head, int partitionValue){

        ListNode smallerHead = null;
        ListNode largerHead = null;

        ListNode currentNode = head;
        while(currentNode.next !=null){
            if(currentNode.val < partitionValue){
                if(smallerHead == null){
                    smallerHead = new ListNode(currentNode.val);
                }else{
                    smallerHead.addAtEnd(currentNode.val);
                }
            }else{
                if(largerHead == null){
                    largerHead = new ListNode(currentNode.val);
                }else{
                    largerHead.addAtEnd(currentNode.val);
                }
            }
            currentNode = currentNode.next;
        }

        /*
         * now join the two lists together
         */
        currentNode = smallerHead;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = largerHead;

        return smallerHead;
    }

    //------------------------------------------------------------------------------------------------------------------

    public static ListNode partitionLinkedList_2(ListNode head, int partitionValue){



        ListNode smallerHead = null;
        ListNode smallerTail = null;
        ListNode largerHead = null;
        ListNode largerTail = null;

        ListNode currentNode = head;
        while(currentNode.next !=null){

            if(currentNode.val < partitionValue){
                if(smallerHead == null){
                    smallerHead = new ListNode(currentNode.val);
                }else{
                    smallerTail = new ListNode(currentNode.val);
                    ListNode currentSmallerNode = smallerHead;
                    while(currentSmallerNode.next != null){
                        currentSmallerNode = currentSmallerNode.next;
                    }
                    currentSmallerNode.next = smallerTail;
                }
            }else{
                if(largerHead == null){
                    largerHead = new ListNode(currentNode.val);
                }else{
                    largerTail = new ListNode(currentNode.val);
                    ListNode currentLargerNode = largerHead;
                    while(currentLargerNode.next!= null){
                        currentLargerNode = currentLargerNode.next;
                    }
                    currentLargerNode.next = largerTail;
                }
            }
            currentNode = currentNode.next;
        }

        /*
         * now join the two lists together
         */
        if(largerHead == null){
            return smallerHead;
        }else{
            smallerTail.next = largerHead;
            return smallerHead;
        }


    }

    //------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args){

        ListNode head = ListNode.createLinkedList();
        head.print();
        head = partitionLinkedList_1(head, 3);
        head.print();

        head = ListNode.createLinkedList();
        head.print();
        head = partitionLinkedList_2(head, 3);
        head.print();

    }
}
