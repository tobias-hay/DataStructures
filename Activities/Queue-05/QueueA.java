public class QueueA<E> implements QueueI<E> {
  private E[] queue;
  private int front;
  private int size;


    QueueA() {
      this(DEFAULT_CAPACITY);
    }

    QueueA(int capacity) {
      queue = (E[]) new Object[capacity];
      front = 0;
      size = 0;
    }

    @Override
    public void enqueue(E obj) {
      if (isFull()) {
        System.err.println("Queue is full");
        return;
      }

      // FIND BACK: front + size,
      // WRAP: mod on arr length
      int avail = (front + size) % queue.length;
      queue[avail] = obj;
      size++;
    }

    @Override
    public E dequeue() {
      if (isEmpty()) {
        System.err.println("Nothing to dequeue");
        return null;
      }

      E tmp = queue[front];

      front = ++front % queue.length;
      size--; 

      return tmp;
    }

    @Override
    public E peek() {
      if (isEmpty()) {
        System.err.println("Nothing to peek");
        return null;
      }

      return queue[front];
    }

    @Override
    public int size() {
      return size;
    }

    @Override
    public boolean isEmpty() {
      return size == 0;
    }

    @Override
    public boolean isFull() {
      return size == queue.length;
    }

    @Override 
    public String toString() {
      String str = "";

      for (int i = 0; i < queue.length; i++) {
        str += queue[i] + " : ";
      }

      str += "\nFront: " + front;
      str += "\nSize: " + size;
      
      return str;
    }
}
