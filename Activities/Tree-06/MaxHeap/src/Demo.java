import Heap.MaxHeap;

public class Demo {
  public static void main(String[] args) {
    MaxHeap heap = new MaxHeap(2);
    int[] els = { 52, 68, 22, 10, 29, 86, 82, 29, 39, 28, 23, 66 };

    for (int i : els) {
      heap.insert(i);
    }

    System.out.println(heap);

    while (heap.size() != 0) {
      System.out.print(heap.remove() + " ");
    }
  }
}
