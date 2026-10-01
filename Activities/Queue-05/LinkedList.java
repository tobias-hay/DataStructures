/**
 * 1) When impl a stack, you don't know the size of the stack nor need access to any other elements than the top.
 * 2) Thinking about all the edge cases
 * 3) An ADT is just a way to store data without the programer having to worry about how its handled
 */


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
        Node<E> node = new Node<>(obj);

        node.next = head;
        head = node;

        currentSize++;
    }

    public E getFront() {
        if (head == null) {
            return null;
        }
        
        return head.data;
    }

    @Override
    public void addBack(E obj) {
        if (head == null) {
            addFront(obj);
            return;
        }

        Node<E> tmp = head;

        while (tmp.next != null) {
            tmp = tmp.next;
        }

        Node<E> node = new Node<>(obj);
        tmp.next = node;
        currentSize++;

        return;
    }

    @Override
    public E removeFront() {
        if (head == null) {
            return null;
        }

        E data = head.data;
        head = head.next;

        currentSize--;

        return data;
    }

    @Override
    public E removeBack() {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return removeFront();
        }

        Node<E> curr = head;
        Node<E> prev = null;

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
        currentSize--;

        return curr.data;
    }

    @Override
    public E get(long n) {
        if (head == null) {
            return null;
        }

        if (n > currentSize) {
            return null;
        }

        Node<E> tmp = head;

        for (int i = 0; i < n; i++) {
            tmp = tmp.next;
        }

        return tmp.data;
    }

    @Override
    public long indexOf(E obj) {
        if (head == null) {
            return -1;
        }

        Node<E> tmp = head;
        long index = 0;

        while (tmp != null) {
            if (((Comparable<E>) tmp.data).compareTo(obj) == 0) {
                return index;
            }

            tmp = tmp.next;
            index++;
        }

        return -1;
    }

    @Override
    public boolean contains(E obj) {
        return indexOf(obj) != -1;
    }

    @Override 
    public String toString() {
        Node<E> tmp = head;
        String str = "(" + currentSize + ") head -> ";

        while (tmp != null) {
            str += tmp.data + " -> ";
            tmp = tmp.next;
        }

        str += "null";

        return str;
    }
  
}