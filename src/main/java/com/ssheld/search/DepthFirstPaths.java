package com.ssheld.search;

import com.ssheld.graphs.Graph;

import java.util.Stack;

public class DepthFirstPaths {

    // Marks a vertex as having been visited
    private boolean[] marked;
    // Last vertex on known path to this vertex
    private int[] edgeTo;
    // Source
    private final int source;

    public DepthFirstPaths(Graph g, int source) {
        this.source = source;
        marked = new boolean[g.getNumVertices()];
        edgeTo = new int[g.getNumVertices()];
        dfs(g, source);
    }

    /**
     * Depth-first search of graph g starting at vertex v
     */
    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    /**
     * Returns whether there is a path between source and vertex v
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * Returns an iterable of path from source to vertex v
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> path = new Stack<>();
        // Push all vertices s+1 to v
        for (int x = v; x != source; x = edgeTo[x]) {
            path.push(x);
        }
        // Push source vertex
        path.push(source);
        return path;
    }

}
