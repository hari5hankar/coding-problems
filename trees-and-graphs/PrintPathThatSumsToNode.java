import java.util.Stack;

public class PrintPathThatSumsToNode {

	public static void printPath(TreeNode root, int sum) {
		Stack<Integer> stack = new Stack<>();
		printPath(stack, root, sum);
	}

	public static void printPath(Stack<Integer> stack, TreeNode root, int sum) {
		if (root == null)
			return;
		stack.push(root.key);
		if (sum == stackSum(stack))
			printStack(stack);  //print here and continue, there could be more paths
		printPath(stack, root.left, sum);
		printPath(stack, root.right, sum);
		stack.pop();
	}

	private static int stackSum(Stack<Integer> stack) {
		int sum = 0;
		for (int i : stack)
			sum += i;
		return sum;
	}

	private static void printStack(Stack<Integer> stack) {
		for (int i : stack)
			System.out.print("(" + i + ")");
		System.out.println();
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
		printPath(root, 10);
	}

}
