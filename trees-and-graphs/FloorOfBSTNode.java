
/*
 * the floor of a key is the smallest key greater than or equal to the given key. 
 */
public class FloorOfBSTNode {

	public static BSTNode floor(BSTNode root, int key) {
		if (root == null)
			return null;

		// if key is equal root is the floor
		if (key == root.key)
			return root;

		// if root is greater, floor MUST be in left subtree
		else if (key < root.key)
			return floor(root.left, key);

		// if root is smaller, floor MAY be in right subtree. Else it is root.
		else {
			BSTNode node = floor(root.right, key);
			if (node == null)
				return root;
			else
				return node;
		}
	}

	public static void main(String[] args) {
		BSTNode root = BSTNode.createBST();
		System.out.println(floor(root, 13).key);
	}

}
