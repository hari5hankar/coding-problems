
/*
 * the floor of a key is the smallest key greater than or equal to the given key. 
 */
public class FloorOfBSTNode {

	public static BSTNode floor(BSTNode root, int key){
		if(root == null) return null;
		if(key == root.key) return root;
		else if(key > root.key) return floor(root.right, key);
		else {
			BSTNode node = floor(root.left, key);
			if(node == null) 
				return root;
			else	
				return node;
		}
	}

	
	public static void main(String[] args) {
		BSTNode root = BSTNode.createBST();
		System.out.println(floor(root, 13).key);
	}

}
