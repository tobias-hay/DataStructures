public class StackL<E> implements StackI<E> {
  private LinkedList<E> ll;
  private int top;

  //Constr
  public StackL() {
    this.ll = new LinkedList<>(); // Cast to E
    this.top = -1;
  }
  
  @Override 
  public void push(E obj) {
    ll.addBack(obj);
    top++;
  }

  /** 
   * Return top element of ll and dec top, returns null if empty 
   * @see StackI#pop()
   */
  @Override
  public E pop() {
    if (isEmpty()) {
      return null;
    }

    return ll.get(top--);
  }

  /**  
   * Returns top elm of llay, null if empty
   * @see StackI#peek()
   */
  @Override
  public E peek() {
    if (isEmpty()) {
      return null;
    }

    return ll.get(top);
  }

  @Override
  public int size() {
    return top + 1;
  }

  @Override
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

  @Override
  public int capacity() {
    System.err.println("Linked List based stack has no maximum capacity");
    return -1;
  }

  @Override
  public boolean isFull() {
    System.err.println("Linked List based stack has no maximum capacity");
    return false;
  }
  
}
