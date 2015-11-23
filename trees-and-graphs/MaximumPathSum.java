
public class MaximumPathSum {

	public static int maximumPathSum(TreeNode root) {
		if(root == null) return 0;
		int left = maximumPathSum(root.left);
		int right = maximumPathSum(root.right);
		int sum = (left>right)? left : right;
		return sum + root.val;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTreeTwo();
		System.out.println(maximumPathSum(root));
	}
}
