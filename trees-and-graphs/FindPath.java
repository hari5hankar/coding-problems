import java.util.Stack;

public class FindPath {

	public static void findPath(TreeNode root, int key) {
		Stack<Integer> stack = new Stack<>();
		findPath(root, key, stack);
		for(int i : stack)
			System.out.print(i + " ");
	}

	public static boolean findPath(TreeNode root, int key, Stack<Integer> stack) {
		if (root == null)
			return false;
		stack.push(root.val);
		if (root.val == key)
			return true;
		else if (findPath(root.right, key, stack) || findPath(root.left, key, stack))
			return true;
		else {
			stack.pop();
			return false;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTreeTwo();
		findPath(root, -4);
	}
}
