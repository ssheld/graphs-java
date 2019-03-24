package com.ssheld.Search;

import com.ssheld.Graph.Graph;

/**
 * Author: Stephen Sheldon 3/24/2019
 */

public class DepthFirstSearch {
    // Array to store vertices as being visited
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        // Initialize to number of vertices in graph
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    // Return whether there is a path between source vertex and vertex v
    public boolean marked(int v) {
        return marked[v];
    }

    // Return the number of vertices connected to the source vertex
    public int count() {
        return count;
    }
}
