import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int key) {
		this.val = key;
	}

/* 
    		1
 		  /    \
		 2      3
		/ \    / \
	   4   5  6   7
*/
	
	public static TreeNode createBinaryTree() {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		return root;
	}
	
/*	
       10
	  /  \
	-2    7 
	/ \
   8  -4  
*/

	public static TreeNode createBinaryTreeTwo() {

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(-4);
		return root;
	}

	public static void printLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode x = queue.remove();
			System.out.println(x.val);
			if (x.left != null)
				queue.add(x.left);
			if (x.right != null)
				queue.add(x.right);
		}
	}
	
	@Override
	public String toString(){
		return Integer.toString(this.val);
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTree();
		printLevelOrder(root);
	}
}
