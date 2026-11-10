import Graph.Graph;
import Graph.Node;

public class App {
    public static void main(String[] args) throws Exception {
        Graph pa = new Graph();

        // for (int i = 0; i < cities.length(); i++) {
        // char city = cities.charAt(i);

        // Node c = new Node(city+""); // make it a string
        // pa.addNode(c);
        // }

        Node w = new Node("W");
        Node e = new Node("E");
        Node o = new Node("O");
        Node a = new Node("A");
        Node p = new Node("P");
        Node h = new Node("H");
        Node i = new Node("I");
        Node j = new Node("J");

        pa.addNode(w);
        pa.addNode(e);
        pa.addNode(o);
        pa.addNode(a);
        pa.addNode(p);
        pa.addNode(h);
        pa.addNode(i);
        pa.addNode(j);

        pa.addEdge(w, o, 21);
        pa.addEdge(w, h, 20);
        pa.addEdge(w, j, 22);
        pa.addEdge(w, e, 40);

        pa.addEdge(e, w, 40);
        pa.addEdge(e, i, 35);

        pa.addEdge(o, w, 21);
        pa.addEdge(o, a, 16);

        pa.addEdge(a, o, 16);
        pa.addEdge(a, p, 18);

        pa.addEdge(p, a, 18);
        pa.addEdge(p, h, 21);

        pa.addEdge(h, w, 20);
        pa.addEdge(h, p, 21);
        pa.addEdge(h, i, 41);

        pa.addEdge(i, e, 35);
        pa.addEdge(i, h, 41);
        pa.addEdge(i, j, 10);

        pa.addEdge(j, w, 22);
        pa.addEdge(j, i, 10);

        pa.printGraph();

        pa.prims();
    }
}
