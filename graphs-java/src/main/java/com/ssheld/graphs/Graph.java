package com.ssheld.graphs;

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

    public void addEdge(int v, int w) {}

    public void printGraph() {}
}
