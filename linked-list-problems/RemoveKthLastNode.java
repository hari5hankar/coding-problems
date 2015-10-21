
/**
 * Created by Harishankar on 17-06-2015.
 */
public class RemoveKthLastNode {

    public static ListNode removeKthLastNode(ListNode head, int k){

        int N = 0; //size of linked list
        ListNode currentNode = head;

        while(currentNode != null){
            currentNode = currentNode.next;
            N++;
        }

        if(N == k){
            return head.next;
        }

        currentNode = head;
        ListNode previousNode = head;
        ListNode nextNode = null;
        int i = 0;

        while(i < N - k){
            previousNode = currentNode;
            currentNode = currentNode.next;
            nextNode = currentNode.next;
            i++;
        }
        previousNode.next = nextNode;
        return head;
    }

    public static void main(String[] args){

        ListNode head = ListNode.createLinkedList();
        head = removeKthLastNode(head, 1);
        head.print();
    }
}
