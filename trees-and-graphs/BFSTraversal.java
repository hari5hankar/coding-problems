import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {

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
	
	public static void main(String[] args) {
		BSTNode root = BSTNode.createBST();
		levelOrder(root);
	}
}
