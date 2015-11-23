
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PreToPost {
	public int pIndex = 0;
    static List<Integer> postList=new ArrayList<Integer>();
	public TNode constructTree(int[] preorder, int data, int min, int max) {
		if (pIndex < preorder.length) {
			if (preorder[pIndex] > min && preorder[pIndex] < max) {
				TNode root = new TNode(data);
				pIndex++;
				if (pIndex < preorder.length) {
					// nodes lies between min and data will create left subtree
					root.left = constructTree(preorder, preorder[pIndex], min,
							data);
					// nodes lies between data and max will create right subtree
					root.right = constructTree(preorder, preorder[pIndex],
							data, max);
				}
				return root;
			}
		}
		return null;
	}

	public void displayTree(TNode root) {
		if (root != null) {
			displayTree(root.left);
			displayTree(root.right);
			postList.add(root.data);
		}
	}

	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		List<Integer> inputList=new ArrayList<Integer>();
		while(scanner.hasNext()){
			inputList.add(scanner.nextInt());
		}
		PreToPost p = new PreToPost();
		int[] preOrder = new int[inputList.size()];
		for(int i=0;i<inputList.size();i++){
			preOrder[i]=inputList.get(i);
		}
		TNode root = p.constructTree(preOrder, preOrder[0], Integer.MIN_VALUE,
				Integer.MAX_VALUE);
		System.out.println("Inorder Traversal of Constructed Tree : ");
		p.displayTree(root);
		for(int data:postList){
			System.out.println(data);
		}
		scanner.close();
	}
}

class TNode {
	int data;
	TNode left;
	TNode right;

	public TNode(int data) {
		this.data = data;
	}
}
