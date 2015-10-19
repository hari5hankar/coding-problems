import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Geneology {

	private class Node {
		public Node parent;
		public String name;
		public List<Node> children = new ArrayList<>();
	}

	Node root = null;
	Map<String, Node> map = new HashMap<>();

	public Geneology(String input) {
		String[] args = input.split(",");
		for (int i = 0; i < args.length; i++) {

			String[] a = args[i].split("->");

			Node parent;
			Node child;

			if (map.containsKey(a[0])) {
				parent = map.get(a[0]);
			} else {
				parent = new Node();
				parent.name = a[0];
				map.put(a[0], parent);
			}

			if (map.containsKey(a[1])) {
				child = map.get(a[1]);
			} else {
				child = new Node();
				child.name = a[1];
				map.put(a[1], child);
			}

			parent.children.add(child);
			child.parent = parent;

			if (root == null) {
				root = parent;
			}

			if (root == child) {
				Node current = child;
				while (current.parent != null) {
					current = current.parent;
				}
				root = current;
			}
		}
	}

	public void getGeneology(int level) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		int currentLevel = 1;
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			if (node == null) {
				if (queue.isEmpty())
					break;
				queue.add(null);
				currentLevel++;
			} else {
				if (currentLevel == level) {
					System.out.print(node.name + " ");
					while ((node = queue.remove()) != null) {
						System.out.print(node.name + " ");
					}
					return;
				}
				for (Node n : node.children) {
					queue.add(n);
				}
			}
		}
	}

	public static void main(String[] args) {
		Geneology g = new Geneology("Sam->Pete,Sam->Katie,Mary->Bob,Frank->Mary,Mary->Sam,Bob->John");
		g.getGeneology(4);
	}
}
