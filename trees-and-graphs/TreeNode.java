import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

	public int key;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int key) {
		this.key = key;
	}



/*
    		1
 		  /    \
		 2      3
		/ \    / \
	   4   5  6   7
*/
	public static TreeNode createBinaryTree() {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		return root;
	}

	public static void printLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode x = queue.remove();
			System.out.println(x.key);
			if (x.left != null)
				queue.add(x.left);
			if (x.right != null)
				queue.add(x.right);
		}
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTree();
		printLevelOrder(root);
	}
}
