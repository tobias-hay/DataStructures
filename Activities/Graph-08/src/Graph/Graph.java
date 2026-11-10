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

  /**
   * Mark all nodes in the graph as having not been visited yet.
   */
  private void resetAllNodeVisitState() {
    for (Node node : nodes) {
      node.visited = false;
    }
  }

  /**
   * Util to check if you have visited all nodes in the graph
   */
  private boolean allNodesVisited() {
    for (Node node : nodes) {
      if (!node.visited)
        return false;
    }

    return true;
  }

  private Edge findSmallestEdge() {
    int min = Integer.MAX_VALUE;
    Edge candidate = null;

    for (Node node : nodes) {
      if (node.visited) {
        for (Edge edge : node.edges) {
          if (edge.weight < min && !edge.end.visited) {
            min = edge.weight;
            candidate = edge;
          }
        } // end for edge
      } // end node if
    } // end for node

    return candidate;
  }

  /**
   * Print out the MST of the graph using Prim's algo
   * 
   * Graph must already be constructed by the caller.
   */
  public void prims() {
    int mst_weight = 0;

    if (DEBUG)
      System.out.println("PRIM");

    // Mark all nodes as un-visited
    resetAllNodeVisitState();

    // Identify a starting node
    Node tmp = nodes.getFirst();
    if (DEBUG)
      System.out.println("Starting at node: " + tmp);

    tmp.visit();
    if (DEBUG)
      System.out.println(tmp + " marked as visited");

    // Continue until all nodes are visited
    if (DEBUG)
      System.out.println("Visit all nodes");

    while (!allNodesVisited()) {
      // Find smallest edge
      Edge smallestEdge = findSmallestEdge();
      if (DEBUG)
        System.out.println("Smallest edge: " + smallestEdge);

      // Add cost to total
      mst_weight += smallestEdge.weight;

      // Mark dest as visited
      smallestEdge.end.visit();
    }

    // Report final weight
    System.out.println("Total MST cost is " + mst_weight);
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
