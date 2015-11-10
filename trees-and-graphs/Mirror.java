
public class Mirror {

	public static void  mirror(TreeNode root){
		if(root == null || root.left == null || root.right == null) return;
		int temp = root.left.val;
		root.left.val = root.right.val;
		root.right.val = temp;
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
