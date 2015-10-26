import java.util.Collections;

public class QueueUsingStack<Item> {

	Stack<Item> one;
	Stack<Item> two;

	public QueueUsingStack() {
		one = new Stack<Item>();
		two = new Stack<Item>();
	}

	public void enqueue(Item data) {
		one.push(data);
	}

	public Item dequeue() {
		if (two.isEmpty())
			copyOver();
		return two.pop();
	}

	public Item peek() {
		if (two.isEmpty())
			copyOver();
		return two.peek();
	}

	public boolean isEmpty() {
		return one.isEmpty() && two.isEmpty();
	}

	public int size() {
		if (one.isEmpty())
			return two.size();
		return one.size();
	}

	// Helper
	private void copyOver() {
		while (!one.isEmpty()) {
			two.push(one.pop());
		}
	}

	public static void main(String[] args) {

		QueueUsingStack<Integer> q = new QueueUsingStack<Integer>();
		for (int i = 0; i < 10; i++) {
			q.enqueue(i);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(q.dequeue());
		}
	}

}
