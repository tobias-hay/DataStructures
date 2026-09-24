public class HTMLValidator {
  public static void main(String[] args) {
    String[] test = {
      "<html></html>",
      "<html><head></head><body></body></html>",
      "<html><head><title>testing</title></head><body><h1>heading</h1></body></html>",
      "<html><head></html></html>"
    };

    try {
      for (String str : test) {
        System.out.println((isValid(str) ? "valid" : "invalid"));
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

  }

  private static boolean isValid(String html) {
    StackA<String> stack = new StackA<>();

    int start = html.indexOf("<");

    while (start != -1) {
      int end = html.indexOf(">", start + 1);

      if (end == -1) {
        return false;
      }

      String tag = html.substring(start + 1, end);

      //TODO: Handle atributes

      System.out.println(tag);

      if (tag.startsWith("/")) { // Closing tag
        if (!tag.substring(1).equals(stack.pop())) {
          return false;
        }
      } else { // Opening Tag
        stack.push(tag);
      }

      start = html.indexOf("<", end);
    }

    return stack.isEmpty();
  }
}
