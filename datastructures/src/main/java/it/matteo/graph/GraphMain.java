package it.matteo.graph;

/**
 * A simple undirected and unweighted graph implementation.
 *
 */
public class GraphMain {

    /**
     * Unit tests the {@code Graph} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(4, 2);

        System.out.println("Size:    " + graph.getSize());
        System.out.println(graph);
        System.out.println();
    }
}
