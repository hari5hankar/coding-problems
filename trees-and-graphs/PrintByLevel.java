import java.util.LinkedList;
import java.util.Queue;

public class PrintByLevel {

	public static void printByLevel(BSTNode root) {
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

	public static void main(String[] args) {
		BSTNode root = BSTNode.createBST();
		printByLevel(root);
	}

}
