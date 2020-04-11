/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.matteo.graph;

import java.util.Objects;

/**
 *
 * @author matteo.minardi
 */
public class Vertex<T> {

    private final T key;

    public Vertex(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
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
        final Vertex<?> other = (Vertex<?>) obj;
        if (!Objects.equals(this.key, other.key)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.key);
        return hash;
    }

    @Override
    public String toString() {
        return "Vertex{" + "key=" + key + '}';
    }

}
