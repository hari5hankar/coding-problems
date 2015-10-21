
import java.util.Stack;

/**
 * Created by Harishankar on 26-06-2015.
 */
public class IsPalindrome {


    public static boolean isPalindrome(ListNode head){

        Stack<Integer> stack = new Stack<Integer>();
        ListNode currentNodeSlow = head;
        ListNode currentNodeFast = head;

        while(currentNodeFast.next != null && currentNodeFast.next.next != null){
            stack.push(currentNodeSlow.val);
            currentNodeSlow = currentNodeSlow.next;
            currentNodeFast = currentNodeFast.next.next;
        }

        if(currentNodeFast.next != null){
            currentNodeSlow = currentNodeSlow.next;
        }else{
            stack.push(currentNodeSlow.val);
        }

        while(!stack.isEmpty()){
            if(stack.pop() != currentNodeSlow.val){
                return false;
            }
            currentNodeSlow = currentNodeSlow.next;
        }

        return true;


    }



    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.addAtEnd(2);
        head.addAtEnd(1);
/*
        head.addAtEnd(2);
        head.addAtEnd(1);
*/

        System.out.println(isPalindrome(head));
    }
}
