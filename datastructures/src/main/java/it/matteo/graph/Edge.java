package it.matteo.graph;

import java.util.Objects;

/**
 *
 * @author matteo.minardi
 */
public class Edge<T> {

    private final Vertex source;
    private final Vertex destination;
    
    private int weight;

    public Edge(Vertex<T> source, Vertex<T> dest, int weight) {
        this.source = source;
        this.destination = dest;
        this.weight = weight;
    }
    
    public Edge(Vertex<T> source, Vertex<T> dest) {
        this(source, dest, 0);
    }

    public int getWeight() {
        return weight;
    }

    public Vertex<T> getSource() {
        return source;
    }

    public Vertex<T> getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edge<?> other = (Edge<?>) obj;
        if (!Objects.equals(this.source, other.source)) {
            return false;
        }
        if (!Objects.equals(this.destination, other.destination)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public String toString() {
        return "Edge{" + "source=" + source.getKey() + ", destination=" + destination.getKey() + '}';
    }

}
