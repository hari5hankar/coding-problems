
public class CheckIsSubtree {

	public static boolean isTreeASubtree(TreeNode root, TreeNode subroot){
		if(subroot == null) return true; //null is always a subtree
		if(root == null) return false; //we reached the end of the tree, still no match.
		if(root.val == subroot.val)
				if(doTreesMatch(root, subroot)) return true;
		return isTreeASubtree(root.left, subroot) || isTreeASubtree(root.right, subroot);
	}

	private static boolean doTreesMatch(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null && root2 != null)
			return false;
		if (root1 != null && root2 == null)
			return false;

		if (root1.val != root2.val)
			return false;
		return doTreesMatch(root1.left, root2.left) && doTreesMatch(root1.right, root2.right);
	}

	public static void main(String[] args) {
		TreeNode root1 = TreeNode.createBinaryTree();
		TreeNode root2 = TreeNode.createBinaryTree();
		root2.right.val = 26;
		System.out.println(doTreesMatch(root1, root2));
	}
}
