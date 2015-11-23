import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigzagLevelOrder {

	/*********************************************************
	 * Do this using stack instead of queue. Order of insertion in the stack
	 * will be dependent on the level currently on.
	 *********************************************************/
	public static void printZigzagLevelOrder(TreeNode root) {

		if (root == null)
			return;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		boolean lefttoRight = true;
		s1.push(root);
		while (!s1.isEmpty()) {
			TreeNode current = s1.pop();
			System.out.print(current.val + " ");
			if (lefttoRight) { //
				if (current.left != null)
					s2.push(current.left);
				if (current.right != null)
					s2.push(current.right);
			} else {
				if (current.right != null)
					s2.push(current.right);
				if (current.left != null)
					s2.push(current.left);
			}
			if (s1.isEmpty()) {
				System.out.println();
				lefttoRight = !lefttoRight;
				s1 = s2;
				s2 = new Stack<>();
			}
		}

	}

	/*********************************************************
	 * .
	 *********************************************************/
	public static List<List<Integer>> zigzagLevelOrder_2(TreeNode root) {

		List<List<Integer>> zigzag = new ArrayList<>();

		if (root == null)
			return zigzag;

		List<TreeNode> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(null);
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.remove();
			if (queue.isEmpty()) {
				list.add(null);
				break;
			} else if (temp == null) {
				list.add(null);
				queue.add(null);
			} else {
				list.add(temp);
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
		}

		boolean LtoR = false;
		for (int i = 0; i < list.size(); i++) {
			List<Integer> level = new ArrayList<>();
			if (LtoR) {
				Queue<Integer> lr = new LinkedList<>();
				while (list.get(i) != null) {
					lr.add(list.get(i++).val);
				}
				while (!lr.isEmpty()) {
					level.add(lr.remove());
				}
			} else {
				Stack<Integer> rl = new Stack<>();
				while (list.get(i) != null) {
					rl.push(list.get(i++).val);
				}
				while (!rl.isEmpty()) {
					level.add(rl.pop());
				}
			}
			zigzag.add(level);
			LtoR = !LtoR;
		}

		return zigzag;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTree();
		printZigzagLevelOrder(root);
}

}
