import java.util.Collections;

public class QueueUsingStack<Item> {

	Stack<Item> main;
	Stack<Item> temp;
	
	public QueueUsingStack() {
		main = new Stack<Item>();
		temp = new Stack<Item>();
	} 
	
	public void enqueue(Item data) {
		while(!temp.isEmpty()) {
			main.push(temp.pop());
		}
		main.push(data);
	}
	
	public Item dequeue() {
		while(!main.isEmpty()) {
			temp.push(main.pop());
		}
		return temp.pop();
	}
	
	public boolean isEmpty() {
		return main.isEmpty() && temp.isEmpty();
	}
	
	public int size() {
		if(main.isEmpty()) return temp.size();
		return main.size();
	}
	
	public static void main(String[] args) {

		//Collections.sort(list);
		QueueUsingStack<Integer> q = new QueueUsingStack<Integer>();
		q.enqueue(8);
		q.enqueue(7);
		q.enqueue(6);
		q.enqueue(5);
		System.out.println(q.dequeue());
		q.enqueue(4);
		q.enqueue(3);
		q.enqueue(2);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(1);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
	
}
