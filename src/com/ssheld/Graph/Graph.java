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
    public Graph() {

        try {
            Scanner fin = new Scanner(new File("smallCG"));

            // Initialize our edge count to zero
            this.E = 0;
            // Get the number of vertices
            this.V = Integer.parseInt(fin.nextLine());
            // Get the number of edges from the file
            int e = Integer.parseInt(fin.nextLine());

            // Create array of Linked Lists
            adj = new LinkedList[V];
            // Initialize all lists to empty
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList();
            }

            // Put all edges into our adjacency list
            for (int i = 0; i < e; i++) {
                int v = fin.nextInt();
                int w = fin.nextInt();
                addEdge(v, w);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry could not find/open file smallgraph.txt");
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
