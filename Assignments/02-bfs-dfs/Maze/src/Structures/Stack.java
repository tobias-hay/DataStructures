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
		ll.addBack(obj);
		top++;
	}

	public E pop() {
		if (isEmpty()) {
			return null;
		}

		return ll.get(top--);
	}

	public E peek() {
		if (isEmpty()) {
			return null;
		}

		return ll.get(top);
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

		for (int i = top; i >= 0; i--) {
			str += "| " + ll.get(i) + " |\n";
		}

		str += "---bot---";

		return str;
	}
}
