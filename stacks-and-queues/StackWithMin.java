
public class StackWithMin<Item extends Comparable<Item>> {
	Stack<Item> stack;
	Stack<Item> minStack; // additional stack which keeps track of the min

	public StackWithMin() {
		stack = new Stack<Item>();
		minStack = new Stack<Item>();
	}

	public void push(Item data) {
		stack.push(data);
		if (minStack.isEmpty() || data.compareTo(min()) < 0) {
			minStack.push(data);
		}
	}

	public Item pop() {
		Item data = stack.pop();
		if (data.compareTo(minStack.peek()) == 0) {
			minStack.pop();
		}
		return data;
	}

	public Item min() {
		return minStack.peek();
	}

	public Item peek() {
		return stack.peek();
	}

	public static void main(String[] args) {
		StackWithMin<Integer> stack = new StackWithMin<Integer>();
		stack.push(5);
		stack.push(6);
		stack.push(3);
		stack.push(7);
		System.out.println(stack.pop() + " " + stack.min());
		System.out.println(stack.pop() + " " + stack.min());
	}

}
