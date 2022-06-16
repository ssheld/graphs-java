package com.ssheld.search;

import com.ssheld.graphs.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths {

    private boolean marked[];
    private int[] edgeTo;
    private final int source;

    public BreadthFirstPaths(Graph g, int source) {
        marked = new boolean[g.getNumVertices()];
        edgeTo = new int[g.getNumVertices()];
        this.source = source;
        bfs(g, source);
    }

    private void bfs(Graph g, int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        // Add vertex to queue
        queue.add(s);
        while (!queue.isEmpty()) {
            // Dequeue the first vertex in list
            int v = queue.remove();
            // Loop through adjacency list enqueuing
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    // Save the last edge on shortest path
                    edgeTo[w] = v;
                    // Mark the path because it's known
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }

    /**
     * Checks if there's a path from source to vertex v
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * Return an iterable for vertex v. This way we can iterate
     * through all vertices that make up the path to vertex v
     */
    public Stack<Integer> pathTo(int v) {
        // Let's check to make sure v is even connected to the graph
        if (!hasPathTo(v)) {
            return null;
        }
        // Stack will store all vertices to path
        Stack<Integer> path = new Stack<>();
        // Push vertices along path to stack until we reach our source
        for (int x = v; x != source; x = edgeTo[x]) {
            path.push(x);
        }
        // Finally push the source vertex on the stack
        path.push(source);
        return path;
    }
}
