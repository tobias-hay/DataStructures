public class StackA<E> implements StackI<E> {
  private E[] arr;
  private int top;
  private int capacity;

  //Constr
  
  public StackA() {
    this(10); // Call the other constr that has an arg
  }
  
  public StackA(int capacity) {
    this.capacity = capacity;
    this.arr = (E[]) new Object[this.capacity]; // Cast to E
    this.top = -1;
  }
  
  @Override
  public void push(E obj) {
    if (isFull()) {
      throw new IllegalStateException("Stack is full");
    }

    arr[++top] = obj;
  }

  /** 
   * Return top element of array and dec top, returns null if empty 
   * @see StackI#pop()
   */
  @Override
  public E pop() {
    if (isEmpty()) {
      return null;
    }

    return arr[top--];
  }

  /**  
   * Returns top elm of array, null if empty
   * @see StackI#peek()
   */
  @Override
  public E peek() {
    if (isEmpty()) {
      return null;
    }

    return arr[top];
  }

  @Override
  public int size() {
    return top + 1;
  }

  @Override
  public int capacity() {
    return capacity;
  }

  @Override
  public boolean isEmpty() {
    return top == -1;
  }

  @Override
  public boolean isFull() {
    return top == capacity - 1;
  }

  @Override 
  public String toString() {
    String str = "---top---\n";

    for (int i = top; i >= 0; i--) {
      str += "| " + arr[i] + " |\n";
    }

    str += "---bot---";

    return str;
  }
  
}
