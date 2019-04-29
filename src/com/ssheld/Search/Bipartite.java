package com.ssheld.Search;

import com.ssheld.AdjacencyListGraphs.Graph;

/**
 * Author: Stephen Sheldon 4/3/2019
 *
 * Code to check if a graph is bipartite (two-colorable).
 *
 */

public class Bipartite {
    private boolean[] marked;
    private boolean[] color;
    private boolean isBipartite = true;

    public Bipartite(Graph G) {
        marked = new boolean[G.getNumVertices()];
        color = new boolean[G.getNumVertices()];
        for (int i = 0; i < G.getNumVertices(); i++) {
            if (!marked[i]) {
                dfs(G, i);
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                // Color vertex w the inverse of color of vertex v
                color[w] = !color[v];
                dfs(G, w);
            }
            // If we've visited this vertex W that is adjacent to V, then we need
            // to check if it's the same color as V. If it is then this graph is not two-colorable.
            else if (color[w] == color[v]) {
                isBipartite = false;
            }
        }
    }

    public boolean isBipartite() {
        return isBipartite;
    }
}
