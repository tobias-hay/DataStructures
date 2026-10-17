package Structures;

public class Queue<E> {
	private LinkedList<E> queue;
	private int front;
	private int size;

	Queue() {
		queue = new LinkedList<E>();
		front = 0;
		size = 0;
	}

	public void enqueue(E obj) {
		queue.addBack(obj);
		size++;
	}

	public E dequeue() {
		if (isEmpty()) {
			System.err.println("Nothing to dequeue");
			return null;
		}

		E tmp = queue.removeFront();
		size--;

		return tmp;
	}

	public E peek() {
		if (isEmpty()) {
			System.err.println("Nothing to peek");
			return null;
		}

		return queue.getFront();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		String str = "";

		for (int i = 0; i < queue.size(); i++) {
			str += queue.get(i) + " : ";
		}

		str += "\nFront: " + front;
		str += "\nSize: " + size;

		return str;
	}
}
