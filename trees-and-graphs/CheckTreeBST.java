import java.util.ArrayList;
import java.util.List;

public class CheckTreeBST {

	/***************************************************************************
	 * Trivial: check if in-order traversal gives a sorted array
	 ***************************************************************************/
	public static boolean isBST_1(TreeNode root) {
		List<Integer> a = new ArrayList<>();
		inOrder(root, a);
		for (int i = 0; i < a.size() - 1; i++) {
			if (a.get(i) > a.get(i + 1))
				return false;
		}
		return true;
	}

	private static void inOrder(TreeNode node, List<Integer> list) {
		if (node == null)
			return;
		inOrder(node.left, list);
		list.add(node.val);
		inOrder(node.right, list);
	}

	/***************************************************************************
	 * Recursive: starting with the root, check if each node's value is in the
	 * appropriate range.
	 ***************************************************************************/
	public static boolean isBST_2(TreeNode root) {
		return isBST_2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBST_2(TreeNode node, int min, int max) {
		if (node == null)
			return true;
		if (node.val < min || node.val > max)
			return false;
		return isBST_2(node.left, min, node.val) && isBST_2(node.right, node.val, max);
	}

	/*
	 * 19 / \ 5 24 / \ 1 18
	 */
	private static TreeNode createBST() {

		TreeNode root = new TreeNode(19);
		root.left = new TreeNode(5);
		root.right = new TreeNode(24);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(18);
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTree();
		System.out.println(CheckTreeBST.isBST_1(root));
		System.out.println(CheckTreeBST.isBST_2(root));

		root = CheckTreeBST.createBST();
		System.out.println(CheckTreeBST.isBST_1(root));
		System.out.println(CheckTreeBST.isBST_2(root));
	}

}
