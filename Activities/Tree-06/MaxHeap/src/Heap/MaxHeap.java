package Heap;

public class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap() {
        this(512);
    }

    public MaxHeap(int cap) {
        heap = new int[cap];
        size = 0;
    }

    // Helper Functions
    private int parent(int i) {
        return (i - 1) / 2; // INT DIV
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private boolean hasLeft(int i) {
        return left(i) < size;
    }

    private boolean hasRight(int i) {
        return right(i) < size;
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private void trickleUp(int i) {
        while (i > 0) {
            int p = parent(i);

            if (heap[i] < heap[p])
                break;

            swap(i, p);

            i = p;
        }
    }

    private void trickleDown(int i) {
        while (hasLeft(i)) {
            int leftChild = left(i);
            int largerChildIndex = leftChild;

            if (hasRight(i)) {
                int rightChild = right(i);

                if (heap[leftChild] < heap[rightChild]) {
                    largerChildIndex = rightChild;
                }
            }

            if (heap[largerChildIndex] < heap[i])
                break;

            swap(i, largerChildIndex);

            i = largerChildIndex;
        }
    }

    // Exposed Functions
    public void insert(int value) {
        if (size == heap.length - 1) {
            int[] newHeap = new int[heap.length * 2];

            for (int i = 0; i < heap.length; i++) {
                newHeap[i] = heap[i];
            }

            heap = newHeap;
        }

        heap[size] = value;

        trickleUp(size);

        size++;
    }

    public int remove() {
        if (size == 0)
            return -1;

        int root = heap[0];

        heap[0] = heap[--size];

        trickleDown(0);

        return root;
    }

    public int peek() {
        return heap[0];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return heap.length;
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < size; i++) {
            str += "[" + heap[i] + "]";
        }

        return str;
    }
}
