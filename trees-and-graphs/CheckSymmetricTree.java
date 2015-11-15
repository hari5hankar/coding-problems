
public class CheckSymmetricTree {

	public static boolean isTreeSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isTreeSymmetric(root.left, root.right);
	}

	private static boolean isTreeSymmetric(TreeNode left, TreeNode right){
		if(left == null || right == null) 
			return (left == null && right == null);
		
		//compare the left subtree and inverted right subtree, drawing an imaginary line of inversion across root.
		return (left.val == right.val && isTreeSymmetric(left.left, right.right) && isTreeSymmetric(left.right, right.left));
	}

	private static TreeNode createBinaryTree() {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = createBinaryTree();
		System.out.println(isTreeSymmetric(root));
	}
}
