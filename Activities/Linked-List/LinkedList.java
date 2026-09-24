public class LinkedList<E> implements ListI<E> {

    class Node<E> {
      public Node<E> next;
      public E data;

      Node(E obj) {
        next = null;
        data = obj;
      }
    }

    private Node<E> head;
    private int currentSize;

    @Override
    public long size() {
      return currentSize;
    }

    @Override
    public void addFront(E obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addBack(E obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E removeFront() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E removeBack() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E get(long n) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E indexOf(E obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean contains(E obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
  
}