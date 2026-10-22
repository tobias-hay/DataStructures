package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Heap.MaxHeap;

public class MaxHeapTest {
  @Test
  public void initHeap() {
    MaxHeap heap = new MaxHeap(10);
    MaxHeap heap2 = new MaxHeap();

    assertNotNull(heap);
    assertNotNull(heap2);
  }

  @Test
  public void initHeapSize() {
    MaxHeap heap = new MaxHeap(10);

    assertEquals(heap.capacity(), 10);
  }

  @Test
  public void emptyHeapRemoval() {
    MaxHeap heap = new MaxHeap();

    assertEquals(heap.remove(), -1);
    assertEquals(heap.remove(), -1);
    assertEquals(heap.remove(), -1);
  }

  @Test
  public void isEmpty() {
    MaxHeap heap = new MaxHeap();
    assertEquals(heap.size(), 0);

    heap.insert(0);
    assertEquals(heap.size(), 1);

    heap.remove();
    assertEquals(heap.size(), 0);
  }

  @Test
  public void updatesSize() {
    MaxHeap heap = new MaxHeap(10);

    for (int i = 0; i < 12; i++) {
      heap.insert(i);
    }

    assertEquals(heap.size(), 12);
    assertEquals(heap.capacity(), 20);
  }

  @Test
  public void enqueueAndDequeueSingle() {
    MaxHeap heap = new MaxHeap();

    heap.insert(10);

    int val = heap.remove();

    assertNotNull(val);
    assertEquals(val, 10);

    assertEquals(heap.remove(), -1);
    assertEquals(heap.remove(), -1);
  }

  @Test
  public void enqueueAndDequeueMany() {
    int[] numbers = { 1, 5, 3, 4, 2, 6 };
    int[] numbers2 = { 6, 5, 4, 3, 2, 1 };

    MaxHeap heap = new MaxHeap();

    for (int i : numbers)
      heap.insert(i);

    for (int i = 0; i < numbers.length; i++) {
      int ret = heap.remove();

      assertNotNull(ret);
      assertEquals(ret, numbers2[i]);
    }

    assertEquals(heap.remove(), -1);
    assertEquals(heap.remove(), -1);
  }

  @Test
  public void testPeek() {
    int[] numbers = { 1, 5, 3, 4, 2, 6 };
    int[] numbers2 = { 6, 5, 4, 3, 2, 1 };

    MaxHeap heap = new MaxHeap(10);

    for (int i : numbers)
      heap.insert(i);

    for (int i = 0; i < numbers.length; i++) {
      assertEquals(heap.peek(), numbers2[i]);
      int ret = heap.remove();

      assertNotNull(ret);
      assertEquals(ret, numbers2[i]);
    }

    assertEquals(heap.remove(), -1);
    assertEquals(heap.remove(), -1);
  }

  @Test
  public void testSize() {
    int[] numbers = { 1, 5, 3, 4, 2, 6 };
    int[] numbers2 = { 6, 5, 4, 3, 2, 1 };

    MaxHeap heap = new MaxHeap();

    for (int i : numbers)
      heap.insert(i);

    for (int i = 0; i < numbers.length; i++) {
      assertEquals(heap.size(), numbers.length - i);
      int ret = heap.remove();

      assertNotNull(ret);
      assertEquals(ret, numbers2[i]);
    }

    assertEquals(heap.remove(), -1);
    assertEquals(heap.remove(), -1);
  }

}
