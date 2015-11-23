import java.util.LinkedList;
import java.util.Queue;

public class RightView {
	
	public static void rightView(TreeNode root){
		Queue<TreeNode> q = new LinkedList<>();
		q.add(null);
		q.add(root);
		while(!q.isEmpty()){
			TreeNode node = q.remove();
			if(q.isEmpty()){
				break;
			}else if(node == null){
				q.add(null);
				TreeNode temp = null;
				for(TreeNode t: q){
					if(t == null)
						break;
					else 
						temp = t;
				}
				System.out.println(temp.val);
			}else{
				if(node.left != null) q.add(node.left);
				if(node.right != null) q.add(node.right);
			}
		}
	}
	
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTreeTwo();
		rightView(root);;
	}
}
