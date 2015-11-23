import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	static int i = 0;
	static List<Integer> postList = new ArrayList<Integer>();

	public static TreeNode constructTree(int[] preorder, int data, int min, int max) {

		if (i < preorder.length) {
			if (preorder[i] > min && preorder[i] < max) {
				TreeNode root = new TreeNode(data);
				i++;
				if (i < preorder.length) {
					root.left = constructTree(preorder, preorder[i], min, data);
					root.right = constructTree(preorder, preorder[i], data, max);
				}
				return root;
			}
		}
		return null;
	}

	public static void displayTree(TreeNode root) {
		if (root != null) {
			displayTree(root.left);
			displayTree(root.right);
			postList.add(root.data);
		}
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> inputList = new ArrayList<Integer>();
		while (scanner.hasNext()) {
			inputList.add(scanner.nextInt());
		}
		
		int[] preOrder = new int[inputList.size()];
		for (int i = 0; i < inputList.size(); i++) {
			preOrder[i] = inputList.get(i);
		}
		
		TreeNode root = constructTree(preOrder, preOrder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
		displayTree(root);
		for (int data : postList) {
			System.out.println(data);
		}
		scanner.close();
	}
}

