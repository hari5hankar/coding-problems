import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a sorted array, create a BST with minimal height
 */
public class CreateBSTFromSortedArray {
	
	public static TreeNode createBST(int[] a){
		return createBST(a, 0, a.length -1 );
	}
	

	private static TreeNode createBST(int[] a, int lo, int hi) {
		if(hi < lo) return null; //not hi <= lo (see side note)
		int mid = lo + (hi -lo) / 2;
		TreeNode node = new TreeNode(a[mid]);
		node.left = createBST(a, lo, mid - 1);
		node.right = createBST(a, mid + 1, hi);
		return node;
	}
	
	/*
	 * Side note here: we used hi <= lo in merge sort, as we did no want to merge one
	 * element arrays, they are already sorted. but here , we DO want to create
	 * a node from a single element as well.
	 */	
	
	public static void printByLevel(TreeNode root) {
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
	
	public static void main(String[] args) {
		int[] a = {0, 1, 2, 3, 4, 5, 6};
		TreeNode root = createBST(a);
		printByLevel(root);
	}
	
}
