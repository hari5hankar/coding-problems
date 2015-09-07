import java.util.LinkedList;
import java.util.Queue;

public class BSTNode {

	public int key;
	public BSTNode left;
	public BSTNode right;

	public BSTNode(){
		
	}
	
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
	
	/*
	 * Depth First Traversals.
	 */
	public static void inOrder(BSTNode root) {
		if(root == null) return;
		inOrder(root.left);
		System.out.println(root.key);
		inOrder(root.right);
	}

	public static void preOrder(BSTNode root) {
		if(root == null) return;
		System.out.println(root.key);
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void postOrder(BSTNode root) {
		if(root ==null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.key);
	}
	
	/*
	 * Breadth First Traversals.
	 */
	public static void levelOrder(BSTNode root) {
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
		levelOrder(root);
	}
}