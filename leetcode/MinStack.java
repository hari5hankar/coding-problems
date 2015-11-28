import java.util.Stack;

public class MinStack {

	Stack<Integer> pri = new Stack<>();// primary stack
	Stack<Integer> min = new Stack<>();// stack of only min elements

	public void push(int x) {
		if (pri.isEmpty()) {
			pri.push(x);
			min.push(x);
			return;
		}
		pri.push(x);
		if (x <= min.peek())
			min.push(x);
	}

	public void pop() {
		int x = pri.pop();
		if(x == min.peek()) min.pop();
	}

	public int top() {
		return pri.peek();
	}

	public int getMin() {
		return min.peek();
	}
}
