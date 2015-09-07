import java.util.Stack;

public class CommonAncestorInTree {

	/*
	 * Find path from root to n1 and store it in a vector or array. Find path
	 * from root to n2 and store it in another vector or array. Traverse both
	 * paths till the values in arrays are same. Return the common element just
	 * before the mismatch.
	 */
	public static int commonAncestor1(TreeNode root, int key1, int key2) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		storePath(s1, root, key1);
		storePath(s2, root, key2);
		int i;
		for (i = 0; i < s1.size() && i < s2.size(); i++) {
			if (s1.get(i) != s2.get(i))
				break;
		}
		return s1.get(i - 1);
	}

	/*
	 * Finds the path from root to given node, Stores the path in a list,
	 * returns true if path exists otherwise false.
	 */
	private static boolean storePath(Stack<Integer> stack, TreeNode node, int key) {
		if (node == null)
			return false;
		stack.push(node.key);
		if (key == node.key)
			return true;
		else if (storePath(stack, node.left, key) || storePath(stack, node.right, key)) {
			return true;
		} else {
			stack.pop();
			return false;
		}
	}

	/*
	 * Better soultion, no extra space. the LCA node always has one key in left
	 * subtree, and the other key in the right subtree.
	 */
	public static TreeNode commonAncestor2(TreeNode root, int key1, int key2) {

		if (root == null)
			return null;

		// if the key is found at this node, return this node.
		if (key1 == root.key || key2 == root.key)
			return root;

		// try if the key exits in the left subtree or right subtree.
		TreeNode left = commonAncestor2(root.left, key1, key2);
		TreeNode right = commonAncestor2(root.right, key1, key2);

		// if both return non-null values, it means the current node is the
		// common ancestor
		if (left != null && right != null)
			return root;

		/*
		 * if any one is non-null, and the other is null, it means: 1. the
		 * common ancestor was already found. and should be passed up. 2. Only
		 * one match was found and the common ancestor is above. So it should be
		 * passed up. In both cases it should be passed up.
		 */
		return (left != null) ? left : right;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTree();
		System.out.println(CommonAncestorInTree.commonAncestor1(root, 4, 7));
		System.out.println(CommonAncestorInTree.commonAncestor2(root, 4, 7).key);
	}
}
