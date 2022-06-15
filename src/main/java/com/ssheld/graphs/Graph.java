package com.ssheld.graphs;

import java.util.Iterator;

/**
 * Abstract class for undirected graphs.
 */
public class Graph {
    protected int numVertices;
    protected int numEdges;

    public Graph(int numVertices, int numEdges) {
        this.numVertices = numVertices;
        this.numEdges = numEdges;
    }

    /**
     * This method returns the number of vertices in the graph
     * @return number of vertices in graph
     */
    public int getNumVertices() {
        return numVertices;
    }
    /**
     * This method returns the number of edges in the graph
     * @return number of edges in graph
     */
    public int getNumEdges() {
        return numEdges;
    }

    public Iterable<Integer> adj(int v) {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return null;
            }
        };
    }

    public void addEdge(int v, int w) {}

    public void printGraph() {}
}
