import java.util.LinkedList;
import java.util.Queue;

public class PrintByLevel {

	/*
	 * My solution
	 */
	public static void printByLevel_1(BSTNode root) {
		Queue<Queue<BSTNode>> mainQ = new LinkedList<>();
		Queue<BSTNode> firstQ = new LinkedList<>();
		firstQ.add(root);
		mainQ.add(firstQ);
		while (!mainQ.isEmpty()) {
			Queue<BSTNode> levelQ = mainQ.remove();
			Queue<BSTNode> nextLevelQ = new LinkedList<>();
			for (BSTNode x : levelQ) {
				System.out.print(x.key + " ");
				if (x.left != null)
					nextLevelQ.add(x.left);
				if (x.right != null)
					nextLevelQ.add(x.right);
			}
			if (!nextLevelQ.isEmpty())
				mainQ.add(nextLevelQ);
			System.out.println();
		}
	}

	/*
	 * Narsimha Karumanchi's (Harsh's) solution.
	 */
	public static void printByLevel_2(BSTNode root) {
		Queue<BSTNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			BSTNode node = queue.remove();
			if (node == null) {
				if (queue.isEmpty())
					break;// otherwise we will be stuck in an infinite loop
				queue.add(null);
				System.out.println();
			} else {
				System.out.print(node.key + " ");
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
	}

	public static void main(String[] args) {
		BSTNode root = BSTNode.createBST();
		printByLevel_1(root);
		System.out.println();
		printByLevel_2(root);
	}

}
