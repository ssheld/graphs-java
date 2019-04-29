package com.ssheld.Search;

import com.ssheld.AdjacencyListGraphs.Graph;

import java.util.Stack;

/**
 * Author: Stephen Sheldon 3/25/2019
 *
 * Checks to see if there is a path from source to vertex V.
 */

public class DepthFirstPaths {

    // Last vertex on known path to this vertex
    private int[] edgeTo;
    // Stores whether or not dfs() has been called for a specific vertex
    private boolean[] marked;
    // Source
    private int s;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.getNumVertices()];
        // Create a new edgeTo, size will be the number of vertices in the graph
        edgeTo = new int[G.getNumVertices()];
        this.s = s;
        dfs(G,s);
    }

    private void dfs(Graph G, int v) {
        // Mark that we have visited this node
        marked[v] = true;
        // Cycle through every vertex
        for (int w : G.adj(v)) {
            // Check if we have visited this vertex
            if (!marked[w]) {
                // Store the last vertex on path to vertex w
                edgeTo[w] = v;
                // Run a DFS on vertex w
                dfs(G, w);
            }
        }
    }

    // Returns true/false. Checks if source has a path to vertex v
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    // Return an iterable for vertex v. This way we can iterate
    // through all vertices that make up the path to vertex v
    public Stack<Integer> pathTo(int v) {
        // Let's check to make sure v is even connected to the graph
        if (!hasPathTo(v))
            return null;
        // Stack will store all vertices to path
        Stack<Integer> path = new Stack<>();
        // Push vertices along path to stack until we reach our source
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        // Finally push the source vertex on the stack
        path.push(s);
        return path;
    }
}
