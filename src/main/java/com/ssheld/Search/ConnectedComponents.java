package com.ssheld.Search;

import com.ssheld.AdjacencyListGraphs.Graph;

/**
 * Author: Stephen Sheldon 4/2/2019
 *
 * Algorithm to count the number of connected components in a graph
 * and keep track of what vertices are in each component.
 */

public class ConnectedComponents {

    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponents(Graph G) {
        marked = new boolean[G.getNumVertices()];
        id = new int[G.getNumVertices()];
        // Loop through all vertices
        for (int i = 0; i < G.getNumVertices(); i++) {
            // If vertex i isn't marked then let's recursively call DFS on it
            // to mark all connected components as visited.
            if (!marked[i]) {
                dfs(G, i);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        // Mark all vertices with our current count which represents
        // the current component that we're looking at.
        id[v] = count;

        // Loop through all adjacent vertices to v
        for (int w : G.adj(v)) {
            if(!marked[w]) {
                dfs(G,w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    // Return component ID that a specific vertex is a part of
    public int id(int v) {
        return id[v];
    }

    // Return the number of components in the graph
    public int count() {
        return count;
    }
}

