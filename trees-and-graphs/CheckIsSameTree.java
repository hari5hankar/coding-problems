
public class CheckIsSameTree {

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null & q == null)
			return true;
		if (p != null & q == null || p == null & q != null)
			return false;
		if (p.val != q.val)
			return false;

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	
	public static void main(String[] args) {
		TreeNode root1 = TreeNode.createBinaryTree();
		TreeNode root2 = TreeNode.createBinaryTree();
		root1.right.right.right = new TreeNode(8);
		System.out.println(isSameTree(root1, root2));
	}
}
