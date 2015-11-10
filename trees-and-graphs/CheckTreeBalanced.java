
/*
 * a tree is balanced if for each node, the height of each subtree differs by no more than 1.
 */
public class CheckTreeBalanced {

	/*************************
	 * Solution 1 : Uses two recursions. O(N^2).
	 *************************/

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

	/***************************
	 * Solution 2: Uses only one recursion O(N).
	 *************************/
	public static boolean isTreeBalanced2(TreeNode root) {
		return heightOfTree2(root) != -1;
	}

	// returns the height of the tree rooted at Node root, however returns -1 if
	// at any time the height of the subtrees differ by more than 1.
	public static int heightOfTree2(TreeNode root) {
		if (root == null)
			return 0;

		// calculate height of each subtree
		int l = heightOfTree2(root.left);
		int r = heightOfTree2(root.right);

		// if already not balanced, propagate it back
		if (l == -1 || r == -1)
			return -1;

		// if not balanced now, return -1
		if (Math.abs(l - r) > 1)
			return -1;

		// return the height
		return Math.max(l, r) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTree();
		System.out.println(isTreeBalanced(root));
		root.right = null;
		System.out.println(isTreeBalanced(root));

		root = TreeNode.createBinaryTree();
		System.out.println(isTreeBalanced2(root));
		root.right = null;
		System.out.println(isTreeBalanced2(root));
	}

}
