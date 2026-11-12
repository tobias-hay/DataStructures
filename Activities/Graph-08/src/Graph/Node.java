package Graph;

import java.util.LinkedList;

public class Node {
  public String name;
  public LinkedList<Edge> edges; // Outgoing edges

  // PRIMS
  public boolean visited;

  // DIJKSTRA
  public int dist;
  public Node prev;

  public Node(String name) {
    this.name = name;
    this.edges = new LinkedList<>();

    // PRIMS
    this.visited = false;

    // DIJKSTRA
    this.dist = 0;
    this.prev = null;
  }

  public void visit() {
    this.visited = true;
  }

  @Override
  public String toString() {
    return name;
  }
}
