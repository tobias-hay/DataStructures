package Graph;

import java.util.LinkedList;
import java.util.Stack;

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

  private void resetAllNodeDistData() {
    for (Node node : nodes) {
      node.dist = Integer.MAX_VALUE;
    }
  }

  private void resetAllNodePrevData() {
    for (Node node : nodes) {
      node.prev = null;
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
   * Returns node with smallest dist that is not visited
   * 
   * @return Node or null
   */
  private Node findSmallestNode() {
    int min = Integer.MAX_VALUE;
    Node cNode = null;

    for (Node node : nodes) {
      if (!node.visited) {
        if (node.dist < min) {
          min = node.dist;
          cNode = node;
        }
      }
    }

    return cNode;
  }

  private void printDijkstraTable() {
    System.out.println();

    System.out.printf("%-10s%-10s%-15s%-10s\n", "NAME", "VISITED", "DIST", "PREV");

    for (Node node : nodes) {
      System.out.printf("%-10s%-10s%-15s%-10s\n", node.name, node.visited, node.dist, node.prev);
    }

    System.out.println();
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

  /**
   * Dijkstra Algo
   * 
   * Find the guaranteed shortest path from start to end
   */
  public void dijkstra(Node start, Node end) {
    // Reset all Dijkstra properties
    resetAllNodeVisitState();
    resetAllNodeDistData();
    resetAllNodePrevData();

    Node curr = start;
    curr.dist = 0;

    while (curr != null) {
      if (DEBUG)
        System.out.println("Current node: " + curr + ", dist: " + curr.dist);

      // Found end, no more processing needed
      if (curr == end) {
        break;
      }

      for (Edge edge : curr.edges) {
        if (DEBUG)
          System.out.println("\tEdge: " + edge + ", visited: " + edge.end.visited);

        if (!edge.end.visited) {
          int newDist = curr.dist + edge.weight;
          if (DEBUG)
            System.out.println("\t\tNew Dist: " + newDist + " (" + curr.dist + " + " + edge.weight + ")");

          if (newDist < edge.end.dist) {
            edge.end.dist = newDist;
            edge.end.prev = curr;
            if (DEBUG)
              System.out.println("\t\tUpdated dist for " + edge.end + " to " + edge.end.dist);
          } // end dist if
        } // end visit if
      } // end ege for

      curr.visit();

      if (DEBUG)
        printDijkstraTable();

      curr = findSmallestNode();
    }

    Stack<Node> path = new Stack<>();
    curr = end;

    while (curr != null) {
      path.push(curr);
      curr = curr.prev;
    }

    System.out.println("Shortest path from " + start + " to " + end);

    while (!path.isEmpty()) {
      System.out.println("Go to " + path.pop());
    }
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
