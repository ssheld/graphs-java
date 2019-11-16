package com.ssheld.search;

import com.ssheld.adjacencylistgraphs.Graph;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Author: Stephen Sheldon 3/26/2019
 */

public class BreadthFirstPaths {
    private boolean marked[]; // Keep track if shortest path to this vertex is known
    private int[] edgeTo;     // Last vertex on known path to this tree
    private int s;            // AdjacencyListGraphs source

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.getNumVertices()];
        edgeTo = new int[G.getNumVertices()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        // BFS is FIFO so let's use a queue
        LinkedList<Integer> queue = new LinkedList<>();
        marked[s] = true;
        // Add vertex to the queue
        queue.add(s);
        while (!queue.isEmpty()) {
            // Dequeue the first vertex in the list
            int v = queue.remove();
            // Loop through all vertices adjacent
            // to our current vertex s
            for (int w : G.adj(v)) {
                if(!marked[w]) {
                    // Mark the edge
                    edgeTo[w] = v;
                    marked[w] = true;
                    // If we haven't visited it then add it to the queue
                    queue.add(w);
                }
            }
        }
    }

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
