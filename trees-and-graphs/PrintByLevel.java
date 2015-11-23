import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintByLevel {

	/**************************************************
	 * Use two queues, one for current level and once for next level
	 **************************************************/
	public static void printByLevel_3(TreeNode root) {
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		q1.add(root);
		while (!q1.isEmpty()) {
			TreeNode node = q1.remove();
			System.out.print(node.val + " ");
			if (node.left != null)
				q2.add(node.left);
			if (node.right != null)
				q2.add(node.right);
			if (q1.isEmpty()) {
				q1 = q2;
				q2 = new LinkedList<>();
				System.out.println();
			}
		}
	}

	/****************************************************
	 * Queue of queues
	 *****************************************************/
	public static void printByLevel_1(TreeNode root) {
		Queue<Queue<TreeNode>> mainQ = new LinkedList<>();
		Queue<TreeNode> firstQ = new LinkedList<>();
		firstQ.add(root);
		mainQ.add(firstQ);
		while (!mainQ.isEmpty()) {
			Queue<TreeNode> levelQ = mainQ.remove();
			Queue<TreeNode> nextLevelQ = new LinkedList<>();
			for (TreeNode x : levelQ) {
				System.out.print(x.val + " ");
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

	/****************************************************
	 * Use "null" to keep track of a level change
	 *****************************************************/
	public static void printByLevel_2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			if (queue.isEmpty()) {
				break;// otherwise we will be stuck in an infinite loop
			} else if (node == null) {
				queue.add(null);
				System.out.println();
			} else {
				System.out.print(node.val + " ");
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
	}

	/*
	 * Return a list of list instead.
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(null);
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.remove();
			if (queue.isEmpty()) {
				break;
			} else if (temp == null) {
				list.add(new ArrayList<Integer>());
				queue.add(null);
			} else {
				List<Integer> level = list.get(list.size() - 1);
				level.add(temp.val);
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
		}

		List<List<Integer>> reverse = new ArrayList<>();
		for (int i = list.size() - 1; i >= 0; i--) {
			reverse.add(list.get(i));
		}

		return reverse;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTree();
		//printByLevel_1(root);
		//System.out.println();
		printByLevel_2(root);
		//System.out.println("\n");
		//printByLevel_3(root);
		//System.out.println();
//		for (List<Integer> level : levelOrder(root)) {
//			System.out.println(level);
//		}
	}

}
