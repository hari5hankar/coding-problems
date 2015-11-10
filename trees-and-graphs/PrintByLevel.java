import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintByLevel {

	/*
	 * My solution
	 */
	public static void printByLevel_1(TreeNode root) {
		Queue<Queue<TreeNode>> mainQ = new LinkedList<>();
		Queue<TreeNode> firstQ = new LinkedList<>();
		firstQ.add(root);
		mainQ.add(firstQ);
		while (!mainQ.isEmpty()) {
			Queue<TreeNode> levelQ = mainQ.remove();
			Queue<TreeNode> nextLevelQ = new LinkedList<>();
			for (TreeNode x : levelQ) {
				System.out.print(x.val + " ");
				if (x.left != null)
					nextLevelQ.add(x.left);
				if (x.right != null)
					nextLevelQ.add(x.right);
			}
			if (!nextLevelQ.isEmpty())
				mainQ.add(nextLevelQ);
			System.out.println();
		}
	}

	
	/*
	 * Narsimha Karumanchi's (Harsh's) solution.
	 */
	public static void printByLevel_2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(null);
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			if (queue.isEmpty()){
				break;// otherwise we will be stuck in an infinite loop				
			}
			else if (node == null) {
				queue.add(null);
				System.out.println();
			} else {
				System.out.print(node.val + " ");
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
	}
	
	
	/*
	 * Return a list of list instead.
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if(root == null) return list;
		Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if (queue.isEmpty()){
                break;                
            }
            else if(temp == null){
                list.add(new ArrayList<Integer>());
                queue.add(null);
            }else{
                List<Integer> level = list.get(list.size() - 1);
                level.add(temp.val); 
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
        }
        
        List<List<Integer>> reverse = new ArrayList<>();
        for(int i = list.size() - 1; i >= 0; i--){
        	reverse.add(list.get(i));
        }
        
        return reverse;
    }

	public static void main(String[] args) {
		TreeNode root = TreeNode.createBinaryTree();
		printByLevel_1(root);
		System.out.println();
		printByLevel_2(root);
		System.out.println("\n");
		for(List<Integer> level : levelOrder(root)){
			System.out.println(level);
		}
	}

}
