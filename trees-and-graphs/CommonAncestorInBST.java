
public class CommonAncestorInBST {

	/*
	 * assuming both keys exist in the tree, the common ancestor is the node at
	 * which the search for they two keys diverges.
	 */

	public static BSTNode commonAncestor(BSTNode root, int key1, int key2) {
		if (root == null)
			return null;
		if (key1 < root.key && key2 < root.key)
			return commonAncestor(root.left, key1, key2);
		if (key1 > root.key && key2 > root.key)
			return commonAncestor(root.right, key1, key2);
		/*
		 * diverge happens, when 1. any one key becomes equal to root, in which
		 * case it itself is the common ancestor. 2. when one key is less than
		 * root and the other is greater.
		 */
		return root;
	}

	public static void main(String[] args) {
		BSTNode root = BSTNode.createBST();
		System.out.println(commonAncestor(root, 16, 12).key);
	}

}
