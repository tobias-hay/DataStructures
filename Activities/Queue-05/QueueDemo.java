public class QueueDemo {
  public static void main(String[] args) {
    QueueA<String> q = new QueueA<>();

    q.enqueue("A");
    q.enqueue("B");
    q.enqueue("C");

    System.out.print(q);
  }
}
