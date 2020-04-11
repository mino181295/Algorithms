package it.matteo.graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A simple undirected graph implementation.
 *
 * @param <T> The type that would be used as vertex.
 */
public class Graph<T> {

    int size = 0;

    final private Set<Edge<T>> edges;
    final private Set<Vertex<T>> vertices;

    final private Map<Vertex<T>, Set<Vertex<T>>> adjacencyList;

    /**
     * Create new Graph object.
     *
     * @param v initial vertices
     * @param e initial edges
     */
    public Graph(Iterable<Vertex<T>> v, Iterable<Edge<T>> e) {
        this.edges = new HashSet<>();
        this.vertices = new HashSet<>();
        this.adjacencyList = new HashMap<>();

        v.forEach(this::addVertex);
        e.forEach(this::addEdge);
    }

    /**
     * Create new Graph object.
     */
    public Graph() {
        this(Collections.emptyList(), Collections.emptyList());
    }

    /**
     * Add new vertex to the graph.
     *
     * @param v The vertex object.
     * @return if the graph has the vertex
     */
    public boolean hasVertex(Vertex<T> v) {
        return this.adjacencyList.containsKey(v);
    }

    /**
     * Add new vertex to the graph.
     *
     * @param v The vertex key.
     * @return if the graph has the vertex
     */
    public boolean hasVertex(T v) {
        return this.hasVertex(new Vertex<>(v));
    }

    /**
     * Add new vertex to the graph.
     *
     * @param v The vertex object.
     */
    public void addVertex(Vertex<T> v) {
        if (this.hasVertex(v)) {
            throw new IllegalArgumentException("Vertex already exists.");
        }
        this.vertices.add(v);
        this.adjacencyList.put(v, new HashSet<>());
        this.size++;
    }

    /**
     * Add new vertex to the graph.
     *
     * @param v The vertex key.
     */
    public void addVertex(T v) {
        Vertex vx = new Vertex(v);
        this.addVertex(vx);
    }

    /**
     * Remove the vertex v from the graph.
     *
     * @param v The vertex object that will be removed.
     */
    public void removeVertex(Vertex<T> v) {
        if (!this.hasVertex(v)) {
            throw new IllegalArgumentException("Vertex doesn't exist.");
        }
        this.vertices.remove(v);
        this.adjacencyList.remove(v);
        this.size--;

        for (Vertex<T> u : this.getVertices()) {
            this.adjacencyList.get(u).remove(v);
        }
    }

    /**
     * Remove the vertex key v from the graph.
     *
     * @param v The vertex that will be removed.
     */
    public void removeVertex(T v) {
        Vertex vx = new Vertex(v);
        this.removeVertex(vx);
    }

    /**
     * Add new edge between vertex.
     *
     * @param e The edge object.
     */
    public void addEdge(Edge e) {
        if (!this.hasVertex(e.getSource()) || !this.hasVertex(e.getDestination())) {
            throw new IllegalArgumentException();
        }

        this.edges.add(e);
        this.adjacencyList.get(e.getSource()).add(e.getDestination());
        this.adjacencyList.get(e.getDestination()).add(e.getSource());
    }

    /**
     * Add new weighted edge between vertex.
     *
     * @param v Start vertex.
     * @param u Destination vertex.
     * @param weight weight of the edge
     */
    public void addEdge(Vertex<T> v, Vertex<T> u, int weight) {
        Edge e = new Edge(v, u, weight);
        this.addEdge(e);
    }

    /**
     * Add new edge between vertex.
     *
     * @param v Start vertex key.
     * @param u Destination vertex key.
     */
    public void addEdge(Vertex<T> v, Vertex<T> u) {
        Edge e = new Edge(v, u);
        this.addEdge(e);
    }

    /**
     * Add new edge between vertex.
     *
     * @param v Start vertex.
     * @param u Destination vertex.
     * @param weight weight of the edge
     */
    public void addEdge(T v, T u, int weight) {
        Vertex<T> vxs = new Vertex<>(v);
        Vertex<T> vxd = new Vertex<>(u);
        this.addEdge(vxs, vxd, weight);
    }

    /**
     * Add new edge between vertex.
     *
     * @param v Start vertex key.
     * @param u Destination vertex key.
     */
    public void addEdge(T v, T u) {
        Vertex<T> vxs = new Vertex<>(v);
        Vertex<T> vxd = new Vertex<>(u);
        this.addEdge(vxs, vxd);
    }

    /**
     * Remove the edge between vertex.
     *
     * @param e The edge that will be removed.
     */
    public void removeEdge(Edge e) {
        if (!this.hasVertex(e.getSource()) || !this.hasVertex(e.getDestination())) {
            throw new IllegalArgumentException();
        }

        this.edges.remove(e);
        this.adjacencyList.get(e.getSource()).remove(e.getDestination());
        this.adjacencyList.get(e.getDestination()).remove(e.getSource());
    }

    /**
     * Remove the edge between vertex.
     *
     * @param v The vertex source key of the edge.
     * @param u The vertex dest key of the edge.
     */
    public void removeEdge(T v, T u) {
        Vertex<T> vxs = new Vertex<>(v);
        Vertex<T> vxd = new Vertex<>(u);
        Edge<T> e = new Edge<>(vxs, vxd);
        this.removeEdge(e);
    }

    /**
     * Check adjacency between 2 vertices in the graph.
     *
     * @param v Start vertex object.
     * @param u Destination vertex object.
     * @return <tt>true</tt> if the vertex v and u are connected.
     */
    public boolean adjacent(Vertex<T> v, Vertex<T> u) {
        return this.adjacencyList.get(v).contains(u);
    }

    /**
     * Check adjacency between 2 vertices in the graph.
     *
     * @param v Start vertex key.
     * @param u Destination vertex key.
     * @return <tt>true</tt> if the vertex v and u are connected.
     */
    public boolean adjacent(T v, T u) {
        Vertex<T> vxs = new Vertex<>(v);
        Vertex<T> vxd = new Vertex<>(u);
        return this.adjacent(vxs, vxd);
    }

    /**
     * Get connected vertices of a vertex.
     *
     * @param v The vertex object.
     * @return An iterable for connected vertices object.
     */
    public Iterable<Vertex<T>> neighbors(Vertex<T> v) {
        return this.adjacencyList.get(v);
    }

    /**
     * Get connected vertices of a vertex.
     *
     * @param v The vertex key.
     * @return An iterable for connected vertices key.
     */
    public Iterable<T> neighbors(T v) {
        Vertex<T> vx = new Vertex<>(v);
        return this.convert(this.neighbors(vx));
    }

    /**
     * Get all edges in the graph.
     *
     * @return An Iterable for all edges in the graph.
     */
    public Iterable<Edge<T>> getAllEdges() {
        return this.edges;
    }

    /**
     * Get all vertices objects in the graph.
     *
     * @return An Iterable for all vertices in the graph.
     */
    public Iterable<Vertex<T>> getVertices() {
        return this.adjacencyList.keySet();
    }

    /**
     * Get all vertices keys in the graph.
     *
     * @return An Iterable for all vertices in the graph.
     */
    public Iterable<T> getVerticesKeys() {
        return this.convert(this.getVertices());
    }

    public int getSize() {
        return this.size;
    }

    private Iterable<T> convert(Iterable<Vertex<T>> vx) {
        Set<T> result = new HashSet<>();
        for (Vertex<T> vv : vx) {
            result.add(vv.getKey());
        }
        return result;
    }

    private String dumpGraph() {
        StringBuilder builder = new StringBuilder("Graph: \n");
        for (T v : this.getVerticesKeys()) {
            builder.append("v : ").append(v).append(": ");
            for (T e : this.neighbors(v)) {
                builder.append("d : ").append(e).append(" | ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return this.dumpGraph();
    }

}
