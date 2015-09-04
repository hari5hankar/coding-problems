import java.util.LinkedList;
import java.util.Queue;

public class BSTNode {

	int key;
	BSTNode left;
	BSTNode right;

	public BSTNode(int key) {
		this.key = key;
	}

	public void put(int key) {
		put(this, key);
	}

	// x is the root of a subtree, which is a tree in itself
	private BSTNode put(BSTNode x, int key) {
		if (x == null)
			return new BSTNode(key);
		if (key < x.key)
			x.left = put(x.left, key);
		else if (key > x.key)
			x.right = put(x.right, key);
		return x;
	}

	public static void printLevelOrder(BSTNode root) {
		Queue<BSTNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BSTNode x = queue.remove();
			System.out.println(x.key);
			if (x.left != null)
				queue.add(x.left);
			if (x.right != null)
				queue.add(x.right);
		}
	}

	public static BSTNode createBST() {
		// "S E A R C H E X A M P L E";
		int keys[] = { 19, 5, 1, 18, 3, 8, 5, 24, 1, 13, 16, 12, 5 };
		BSTNode root = new BSTNode(keys[0]);
		for (int i = 1; i < keys.length - 1; i++)
			root.put(keys[i]);
		return root;
	}

	public static void main(String[] args) {
		BSTNode root = BSTNode.createBST();
		printLevelOrder(root);
	}
}
