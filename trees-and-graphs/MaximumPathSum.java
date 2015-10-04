
public class MaximumPathSum {

	public static int maximumPathSum(TreeNode root) {
		if(root == null) return 0;
		int left = maximumPathSum(root.left);
		int right = maximumPathSum(root.right);
		return (left>right)? root.key + left : root.key + right;
	}
/*
		10
	  /    \
 	 -2     7 
	/ \
   8   -4  
   
*/
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTree();
		System.out.println(maximumPathSum(root));
	}
}
