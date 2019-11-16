package com.ssheld.adjacencylistgraphs;

import java.util.LinkedList;

/**
 * Author: Stephen Sheldon 4/5/2019
 *
 * Class for directed graphs
 *
 */

public class Digraph {
    // Num vertices in graph
    private int numVertices;
    // Num edges in graph
    private int numEdges;
    // Adjacency list
    private LinkedList<Integer>[] adj;

    public Digraph(int numVertices) {
        this.numVertices = numVertices;
        this.numEdges = 0;
        adj = new LinkedList[numVertices];
        // Initialize all vertices to new linked lists
        for (int v = 0; v < numVertices; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    // Return the number of edges in the graph
    public int getNumEdges() {
        return numEdges;
    }

    // Return the number of vertices in the graph
    public int getNumVertices() {
        return numVertices;
    }

    // Add an edge to the digraph
    public void addEdge(int v, int w) {
        adj[v].addFirst(w);
        numEdges++;
    }

    // Return an iterable over all vertices adj to vertex v
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    // Returns a copy of the digraph with all the edges reversed.
    // Needed in digraph processing because it will allow user to find the edges that
    // point to each vertex
    public Digraph reverse() {
        Digraph R = new Digraph(numVertices);
        for (int v = 0; v < numVertices; v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }
}
