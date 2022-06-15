package com.ssheld.graphs;

import java.util.LinkedList;

/**
 * Undirected graph using adjacency lists
 */
public class ListGraph extends Graph {

    private LinkedList<Integer>[] adj;

    /**
     * Constructor for adjacency list graph
     * @param numVertices the number of vertices in the graph
     */
    public ListGraph(int numVertices) {
        super(numVertices, 0);

        adj = new LinkedList[numVertices];

        // Initialize linked lists for every vertex in graph
        for (int i = 0; i < numVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * Add an edge to our graph
     * @param v first vertex of edge
     * @param w second vertex of edge
     */
    @Override
    public void addEdge(int v, int w) {
        adj[v].addFirst(w);
        adj[w].addFirst(v);
        numEdges++;
    }

    /**
     * Creates an Iterable of the vertices adjacent to vertex v
     * @param v the vertex you wish to find adjacent vertices to
     * @return an iterable of all vertices adjacent to v
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * Prints the graph in an adjacency list view
     */
    @Override
    public void printGraph() {
        for (int v = 0; v < numVertices; v++) {
            System.out.printf("Vertex %d: ", v);
            for (int w: adj[v]) {
                System.out.printf("%d ", w);
            }
            System.out.printf("\n");
        }
    }
}
