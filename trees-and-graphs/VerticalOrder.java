import java.util.ArrayList;
import java.util.TreeMap;

public class VerticalOrder {

	/*
	 * Every node is assigned a number. The root is 0. If you go right, give the
	 * node +1, if you go left, give -1. After doing this, nodes with the same
	 * number lie on the same vertical line. Use a Map. Key is the vertical
	 * level number, and Value is a List of number. Fill these while traversing.
	 */
	public static void printByVerticalOrder(TreeNode root) {
		TreeMap<Integer, ArrayList<TreeNode>> map = new TreeMap<>();
		printByVerticalOrder(root, 0, map);
		for (Integer i : map.keySet()) {
			for (TreeNode node : map.get(i)) {
				System.out.print(node.key + " 	");
			}
			System.out.println();
		}
	}

	public static void printByVerticalOrder(TreeNode node, int verticalLevel, TreeMap<Integer, ArrayList<TreeNode>> map) {
		if (node == null)
			return;
		if (map.get(verticalLevel) == null) {
			ArrayList<TreeNode> list = new ArrayList<>();
			list.add(node);
			map.put(verticalLevel, list);
		} else {
			ArrayList<TreeNode> list = map.get(verticalLevel);
			list.add(node);
			map.put(verticalLevel, list);
		}
		printByVerticalOrder(node.left, verticalLevel - 1, map);
		printByVerticalOrder(node.right, verticalLevel + 1, map);
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTree();
		printByVerticalOrder(root);
	}

}
