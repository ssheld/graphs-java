package com.ssheld.Search;

import com.ssheld.AdjacencyListGraphs.Graph;

/**
 * Author: Stephen Sheldon 4/2/2019
 *
 * Cycle keeps track as to whether or not a graph contains cycles (is it acyclic?)
 * Note: This code assumes no self-loops or parallel edges.
 */

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.getNumVertices()];

        for (int i = 0; i < G.getNumVertices(); i++) {
            if (!marked[i]) {
                dfs(G, -1, i);
            }
        }
    }

    private void dfs(Graph G, int u, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, v, w);
            }
            else if (w != u) {
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
