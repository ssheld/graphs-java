package com.ssheld.adjacencylistgraphs;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Author: Stephen Sheldon 4/29/2019
 */

public class ListGraph extends Graph{

    private LinkedList<Integer>[] adj;

    /**
     * Constructor for adjacency list graph
     * @param numVertices the number of vertices in the graph
     */
    public ListGraph(int numVertices) {
        super(numVertices, 0);

        adj = new LinkedList[numVertices];

        // Create LinkedList Objects to represent every vertex in graph
        for (int i = 0; i < numVertices; i++) {
            adj[i] = new LinkedList();
        }
    }

    /**
     * Add an edge to our graph
     * @param v first vertex of edge
     * @param w second vertex of edge
     */
    @Override
    public void addEdge(int v, int w) {
        // Add the edges to each index (undirected graph)
        // and increment our edge count
        adj[v].addFirst(w);
        adj[w].addFirst(v);
        numEdges++;
    }

    /**
     * Creates an Iterable of the vertices adjacent to vertex v
     * @param v the vertex you wish to find adjacent vertices to
     * @return an iterable of all vertices adjacent to v
     */
    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * Prints the graph in an adjacency list view
     */
    @Override
    public void printGraph() {
        for (int i = 0; i < getNumVertices(); i++) {
            System.out.printf("%d: ", i);
            ListIterator listItr = adj[i].listIterator();
            while (listItr.hasNext()) {
                System.out.printf("%d ", listItr.next());
            }
            System.out.printf("%n");
        }
    }

}
