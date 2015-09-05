
public class DFSTraversal {

	public static void inOrder(BSTNode root) {
		if(root == null) return;
		inOrder(root.left);
		System.out.println(root.key);
		inOrder(root.right);
	}

	public static void preOrder(BSTNode root) {
		if(root == null) return;
		System.out.println(root.key);
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void postOrder(BSTNode root) {
		if(root ==null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.key);
	}
	
	public static void main(String[] args) {
		BSTNode root = BSTNode.createBST();
		inOrder(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		postOrder(root);
	}

}
