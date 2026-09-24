public class Demo {
  public static void main(String[] args) {
      StackA<Integer> s1 = new StackA<>();
      StackA<Integer> s2 = new StackA<>(64);

      System.out.println(s1);

      s1.push(1);
      s1.push(2);
      s1.push(3);

      System.out.println(s1);

      System.out.println(s1.pop());
      System.out.println(s1);

      System.out.println("Done");
  }
}
