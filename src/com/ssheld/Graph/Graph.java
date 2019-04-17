package com.ssheld.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Author: Stephen Sheldon 3/24/2019
 */

public class Graph {

    private int V;                      // Number of vertices
    private int E;                      // Number of edges
    private LinkedList<Integer>[] adj;  // Adjacency list

    // Create a V-vertex graph with no edges
    public Graph(int V) {
        this.V = V;
        this.E = 0;

        adj = new LinkedList[V];

        // Create LinkedList Objects to represent every vertex in graph
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList();
        }
    }

    // Add an edge to our adjacency list
    public void addEdge(int v, int w) {
        // Add the edges to each index (undirected graph)
        // and increment our edge count
        adj[v].addFirst(w);
        adj[w].addFirst(v);
        E++;
    }

    // Get the number of vertices in the graph
    public int V() { return V; }

    // Get the number of edges in the graph
    public int E() { return E; }

    // Return the vertices adjacent to the vertex v as an iterable
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public void printAdjList() {
        for (int i = 0; i < V; i++) {
            System.out.printf("%d: ", i);
            ListIterator listItr = adj[i].listIterator();
            while (listItr.hasNext()) {
                System.out.printf("%d ", listItr.next());
            }
            System.out.printf("%n");
        }
    }

}
