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
		boolean key1Exists = storePathIfExists(s1, root, key1);
		boolean key2Exists =storePathIfExists(s2, root, key2);
		if((key1Exists && key2Exists) == false){
			System.out.println("node not found");
			return 0;
		}
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
	private static boolean storePathIfExists(Stack<Integer> stack, TreeNode node, int key) {
		if (node == null)
			return false; //node was not found along this path
		stack.push(node.val);
		if (key == node.val)
			return true;
		else if (storePathIfExists(stack, node.left, key) || storePathIfExists(stack, node.right, key)) {
			return true;
		} else {
			stack.pop();
			return false;
		}
	}

	/*
	 * The idea is to traverse the tree starting from root. If any of the given
	 * keys (n1 and n2) matches with root, then root is LCA (assuming that both
	 * keys are present). If root doesn’t match with any of the keys, we recur
	 * for left and right subtree. The node which has one key present in its
	 * left subtree and the other key present in right subtree is the LCA. If
	 * both keys lie in left subtree, then left subtree has LCA also, otherwise
	 * LCA lies in right subtree.
	 */
	public static TreeNode commonAncestor2(TreeNode root, int key1, int key2) {

		if (root == null)
			return null;

		// if the key is found at this node, return this node.
		if (key1 == root.val || key2 == root.val)
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
		if (left != null && right == null)
			return left;
		else if (left == null && right != null)
			return right;
		else
			return null;

		// return (left != null) ? left : right;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTree();
		root.left.left.val = 20;
		System.out.println(CommonAncestorInTree.commonAncestor1(root, 4, 2));
		System.out.println(CommonAncestorInTree.commonAncestor2(root, 4, 2).val);
	}
}
