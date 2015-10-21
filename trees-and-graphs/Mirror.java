
public class Mirror {

	public static void  mirror(TreeNode root){
		if(root == null || root.left == null || root.right == null) return;
		int temp = root.left.key;
		root.left.key = root.right.key;
		root.right.key = temp;
		mirror(root.left);
		mirror(root.right);
		
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTree();
		TreeNode.printLevelOrder(root);System.out.println();
		mirror(root);
		TreeNode.printLevelOrder(root);
	}
	
}
