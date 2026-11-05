package Graph;

import java.util.LinkedList;

public class Node {
  public String name;
  public LinkedList<Edge> edges; // Outgoing edges

  public Node(String name) {
    this.name = name;
    this.edges = new LinkedList<>();
  }

  @Override
  public String toString() {
    return name;
  }
}
