package com.ssheld.search;

import com.ssheld.graphs.Graph;

public class DepthFirstSearch {
    // Array to store vertices as being visited
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g, int source) {
        // Initialize the number of vertices in graph
        marked = new boolean[g.getNumVertices()];
        dfs(g, source);
    }


    /**
     * Recursive depth-first search implementation
     */
    private void dfs(Graph g, int v) {
        marked[v] = true;
        count++;
        for (int w : g.adj(v)) {
            if (!marked[w])
                dfs(g, w);
        }
    }

    /**
     * Returns whether there is a path between source and vertex v
     */
    public boolean marked(int v) {
        return marked[v];
    }

    /**
     * Returns the number of vertices connected to the source vertex
     */
    public int count() {
        return count;
    }
}
