/*
 * Given a sorted array, create a BST with minimal height
 */
public class CreateBSTFromSortedArray {
	
	public BSTNode createBST(int[] a){
		return createBST(a, 0, a.length -1 );
	}
	
	private BSTNode createBST(int[] a, int lo, int hi) {
		if(hi < lo) return null;
		int mid = lo + (hi -lo) / 2;
		BSTNode node = new BSTNode(a[mid]);
		node.left = createBST(a, lo, mid - 1);
		node.right = createBST(a, mid + 1, hi);
		return node;
	}
	
}
