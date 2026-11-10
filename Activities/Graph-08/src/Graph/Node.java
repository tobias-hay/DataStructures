package Graph;

import java.util.LinkedList;

public class Node {
  public String name;
  public LinkedList<Edge> edges; // Outgoing edges
  public boolean visited;

  public Node(String name) {
    this.name = name;
    this.edges = new LinkedList<>();
    this.visited = false;
  }

  public void visit() {
    this.visited = true;
  }

  @Override
  public String toString() {
    return name;
  }
}
