
/*
 * a tree is balanced if for each node, the height of each subtree differs by no more than 1.
 */
public class CheckTreeBalanced {

	public static boolean isTreeBalanced(TreeNode root) {
		if (root == null)
			return true;
		return (isTreeBalanced(root.left) && isTreeBalanced(root.right)
				&& Math.abs(heightOfTree(root.left) - heightOfTree(root.right)) <= 1);
	}

	public static int heightOfTree(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTree();
		System.out.println(isTreeBalanced(root));
		root.right = null;
		System.out.println(isTreeBalanced(root));
	}

}
