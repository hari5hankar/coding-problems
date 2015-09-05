import java.util.ArrayList;
import java.util.TreeMap;

/*
           1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9 
Output:
4
2
1 5 6
3 8
7
9
*/

public class PrintByVerticalOrder {

	public static void printByVerticalOrder(BSTNode root) {
		TreeMap<Integer, ArrayList<BSTNode>> map = new TreeMap<>();
		printByVerticalOrder(root, 0, map);
		for (Integer i : map.keySet()) {
			for (BSTNode node : map.get(i)) {
				System.out.print(node.key + " 	");
			}
			System.out.println();
		}
	}

	public static void printByVerticalOrder(BSTNode node, int level, TreeMap<Integer, ArrayList<BSTNode>> map) {
		if (node == null)
			return;
		if (map.get(level) == null) {
			ArrayList<BSTNode> list = new ArrayList<>();
			list.add(node);
			map.put(level, list);
		} else {
			ArrayList<BSTNode> list = map.get(level);
			list.add(node);
			map.put(level, list);
		}
		printByVerticalOrder(node.left, level - 1, map);
		printByVerticalOrder(node.right, level + 1, map);
	}

	public static void main(String[] args) {
		BSTNode root = BSTNode.createBST();
		printByVerticalOrder(root);
	}

}
