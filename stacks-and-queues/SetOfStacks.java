
/*
 * implemented using a stack of stacks.
 */

public class SetOfStacks<Item> {
	Stack<Stack<Item>> master;
	private int N; // number of stacks
	private int T; // threshold per stack
	private Stack<Item> top; // top of the stack of stacks

	public SetOfStacks(int threshold) {
		this.T = threshold;
		master = new Stack<Stack<Item>>();
		top = null;
	}

	public int size() {
		return N * T + top.size();
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void push(Item data) {
		if (top == null) {
			top = new Stack<Item>();
			master.push(top);
		}
		top.push(data);
		if (top.size() == T) {
			top = new Stack<Item>();
			master.push(top);
			N++;
		}
	}

	public Item pop() {
		Item data = top.pop();
		if (top.isEmpty()) {
			master.pop();
			if (!master.isEmpty()) top = master.peek();
		}

		return data;
	}

	public Item peek() {
		return top.peek();
	}

	public static void main(String[] args) {

		SetOfStacks<Integer> stack = new SetOfStacks<Integer>(3);
		stack.push(8);
		stack.push(7);
		stack.push(6);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
