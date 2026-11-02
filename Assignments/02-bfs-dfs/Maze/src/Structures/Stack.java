package Structures;

public class Stack<E> {
	private LinkedList<E> ll;
	private int top;

	// Constr
	public Stack() {
		this.ll = new LinkedList<E>();
		this.top = -1;
	}

	public void push(E obj) {
		ll.addFront(obj);
		top++;
	}

	public E pop() {
		if (isEmpty()) {
			return null;
		}

		top--;
		return ll.removeFront();
	}

	public E peek() {
		if (isEmpty()) {
			return null;
		}

		return ll.getFront();
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public String toString() {
		String str = "---top---\n";

		for (int i = 0; i < top; i++) {
			str += "| " + ll.get(i) + " |\n";
		}

		str += "---bot---";

		return str;
	}
}
