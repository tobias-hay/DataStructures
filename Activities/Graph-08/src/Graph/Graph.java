package Graph;

import java.util.LinkedList;

public class Graph {
  private final boolean DEBUG = true;

  // All the nodes
  private LinkedList<Node> nodes;

  public Graph() {
    this.nodes = new LinkedList<>();
  }

  public boolean addNode(Node node) {
    return nodes.add(node);
  }

  public boolean addEdge(Node start, Node end, int weight) {
    return start.edges.add(new Edge(start, end, weight));
  }

  public void printGraph() {
    for (Node node : nodes) {
      for (Edge edge : node.edges) {
        System.out.print(edge);
      }

      System.out.print("\n");
    }
  }
}
