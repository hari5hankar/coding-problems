import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Harishankar on 27-06-2015.
 */

/*
 * a LIFO Stack which internally uses a linked list.
 */

public class Stack<Item> implements Iterable<Item>{

	private int N;
	private Node<Item> head;

	private class Node<Item> {
		Item data;
		Node<Item> next;
	}

	public Stack() {
		head = null;
		N = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return N;
	}

	public void push(Item data) {
		Node oldHead = head;
		head = new Node<Item>();
		head.data = data;
		head.next = oldHead;
		N++;
	}

	public Item pop() {
		if (isEmpty())
			throw new RuntimeException("Stack underflow");
		Node<Item> oldHead = head;
		head = head.next;
		N--;
		return oldHead.data;
	}

	public Item peek() {
		if (isEmpty())
			throw new RuntimeException("Stack underflow");
		return head.data;
	}

	public Iterator<Item> iterator()  { return new ListIterator();  }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node<Item> current = head;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.data;
            current = current.next; 
            return item;
        }
    }
	
	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
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
