
/*
 * the floor of a key is the largest key smaller than or equal to the given key. 
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
		//BSTNode root = BSTNode.createBST();
		BSTNode root = new BSTNode(6);
		root.put(2);
		root.put(7);
		root.put(1);
		root.put(5);
		root.put(0);
		BSTNode.levelOrder(root);
		System.out.println(floor(root, 13).key);
	}

}
