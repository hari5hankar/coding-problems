
public class HeightOfTree {

	public static int heightOfTree(TreeNode root){
		if(root == null) return 0;
		return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTree();
		System.out.println(heightOfTree(root));
	}
	
}
