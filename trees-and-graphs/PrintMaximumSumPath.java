
public class PrintMaximumSumPath {
	/*
	 * we will need two traversals. 
	 * first to find the maximum sum.
	 * then to print the paths that sum to that number.
	 */
	public static void printMaximumSumPath(TreeNode root){
		int max = MaximumPathSum.maximumPathSum(root);
		PathThatSumsToNumber.findPath(root, max);
	}
		
	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTreeTwo();
		printMaximumSumPath(root);
	}
}
