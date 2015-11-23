import java.util.Stack;

public class PathThatSumsToNumber {

	public static void findPath(TreeNode root, int sum) {
		Stack<Integer> stack = new Stack<>();
		findPath(root, sum, 0, stack);
		for (int i : stack)
			System.out.print(i + " ");
	}

	public static boolean findPath(TreeNode root, int requiredSum, int sumTillNow, Stack<Integer> stack) {
		if (root == null)
			return false;
		stack.push(root.val);
		int currentSum = sumTillNow + root.val;
		if (requiredSum == currentSum)
			return true;
		else if(findPath(root.left, requiredSum, currentSum, stack) || findPath(root.right, requiredSum, currentSum, stack))
			return true;
		else{
			stack.pop();
			return false;
		}
	}

/* 
       	1
	  /    \
     2      3
    / \    / \
   4   5  6   7
*/
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTree();
		root.right.left.left = new TreeNode(-1);
		root.right.left.left.right = new TreeNode(+1);
		findPath(root, 10);
	}

}
