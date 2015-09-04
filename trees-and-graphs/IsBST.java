import java.util.ArrayList;
import java.util.List;

/*
 * is the tree a Binary Search Tree? 
 */
public class IsBST {

	/*
	 * trivial solution: check if inorder traversal gives a sorted array.
	 * won't work if avl trees rotation?
	 */
	public static boolean isBST_1(BSTNode root){
		List<Integer> a = new ArrayList<>();
		inOrder(root, a);
		for(int i = 0; i<a.size() - 1; i++){
			if(a.get(i) > a.get(i + 1))
				return false;
		}
		return true;
	}
	
	private static void inOrder(BSTNode node, List<Integer> list){
		if (node == null) return;
		inOrder(node.left, list);
		list.add(node.key);
		inOrder(node.right, list);
	}
	
	/*
	 * recursive solution:
	 * starting with the root, check if each node's value is in the appropriate range.
	 */
	public static boolean isBST_2(BSTNode root) {
		return isBST_2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean isBST_2(BSTNode node, int min, int max) {
		if(node == null) return true;
		if(node.key < min || node.key > max) return false;
		return isBST_2(node.left, min, node.key) && isBST_2(node.right, node.key, max);
	}
	
	public static void main(String[] args) {
		BSTNode root = BSTNode.createBST();
		System.out.println(IsBST.isBST_1(root));
		System.out.println(IsBST.isBST_2(root));
		root.left.right.key = 4;
		System.out.println(IsBST.isBST_1(root));
		System.out.println(IsBST.isBST_2(root));
	}

}
