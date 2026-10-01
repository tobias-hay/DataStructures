public class QueueLL<E> implements QueueI<E> {
  private LinkedList<E> queue;
  private int front;
  private int size;

    QueueLL() {
      queue = new LinkedList<E>();
      front = 0;
      size = 0;
    }

    @Override
    public void enqueue(E obj) {
      // FIND BACK: front + size,
      // WRAP: mod on arr length
      queue.addBack(obj);
      size++;
    }

    @Override
    public E dequeue() {
      if (isEmpty()) {
        System.err.println("Nothing to dequeue");
        return null;
      }

      E tmp = queue.removeFront();
      size--; 

      return tmp;
    }

    @Override
    public E peek() {
      if (isEmpty()) {
        System.err.println("Nothing to peek");
        return null;
      }

      return queue.getFront();
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
      System.err.println("LL Queue can never be full");
      return false;
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
