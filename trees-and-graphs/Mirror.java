
public class Mirror {

	public static void mirror(TreeNode root) {
		if (root == null)
			return;
		mirror(root.left);
		mirror(root.right);
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTree();
		TreeNode.printLevelOrder(root);
		System.out.println();
		mirror(root);
		TreeNode.printLevelOrder(root);
	}

}
