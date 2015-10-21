
/**
 * Created by Harishankar on 17-06-2015.
 */
public class FindKthLastNode {

    public static ListNode findKthLastNode(ListNode head, int k){

        int N = 0; //size of linked list
        ListNode currentNode = head;

        while(currentNode != null){
            currentNode = currentNode.next;
            N++;
        }

        ListNode kthLastNode = head;
        int i =0;
        while(i < N - k){
            kthLastNode = kthLastNode.next;
            i++;
        }
        return kthLastNode;
    }

    //------------------------------------------------------------------------------------------------------------------

    /* a trivial solution, just print the Node,
     * don't return it.
     */

    public static int findKthLastNodeRecursive_1(ListNode head, int k) {

        if (head == null){
            return 0;
        }
        int value = findKthLastNodeRecursive_1(head.next, k) + 1;
        if ( value == k){
            System.out.println(head.val);
        }
        return value;

    }

    //------------------------------------------------------------------------------------------------------------------

    /*
     *  based on the above.
     */

    static class IntegerWrapper{
        int value;

        IntegerWrapper(int value){
            this.value = value;
        }
    }

    public static ListNode findKthLastNodeRecursive_2(ListNode head, int k){
        return findKthLastNodeRecursiveHelper(head,k, new IntegerWrapper(0));
    }


    /*
     *  when end is reached, return a counter set to 0.
     *  Each parent call adds 1 to the counter
     *  When counter == k, we have reached Kth last element.
     */

    private static ListNode findKthLastNodeRecursiveHelper(ListNode head, int k, IntegerWrapper i){

        if (head == null){
            return null;
        }

        ListNode currentNode = findKthLastNodeRecursiveHelper(head.next , k, i);
        i.value += 1;
        if ( i.value == k){
            return head;
        }
        return currentNode;

    }

    //------------------------------------------------------------------------------------------------------------------

    /*  alternate solution
     *  uses a wrapper for the whole node, rather than just an Integer.
     */

    static class NodeWrapper{
        ListNode node;
        int indexFromEnd; //indexFromEnd in linked list from the end

        NodeWrapper(ListNode node, int index){
            this.node = node;
            this.indexFromEnd = index;
        }
    }

    public static ListNode findKthLastNodeRecursive_3(ListNode head, int k){
        //need to pass return a Node and a counter
        NodeWrapper kthLastNode = findKthLastNodeRecursiveHelper(new NodeWrapper(head, -1), k);
        return kthLastNode.node;

    }

    public static NodeWrapper findKthLastNodeRecursiveHelper(NodeWrapper headNodeWrapper, int k){

        if(headNodeWrapper.node == null){
            return new NodeWrapper(null, 0);
        }

        NodeWrapper currentNodeWrapper =  findKthLastNodeRecursiveHelper(new NodeWrapper(headNodeWrapper.node.next, -1), k);
        headNodeWrapper.indexFromEnd = currentNodeWrapper.indexFromEnd + 1;
        if( currentNodeWrapper.indexFromEnd  == k){
            return currentNodeWrapper;
        }else{
            return headNodeWrapper;
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args){

        ListNode head = ListNode.createLinkedList();
        head.print();
        head = findKthLastNode(head, 6);
        head.print();

        head = ListNode.createLinkedList();
        head.print();
        System.out.println(findKthLastNodeRecursive_1(head, 6));
        head.print();

        head = ListNode.createLinkedList();
        head.print();
        head = findKthLastNodeRecursive_2(head, 6);
        head.print();

        head = ListNode.createLinkedList();
        head.print();
        head = findKthLastNodeRecursive_3(head, 6);
        head.print();


    }

}



