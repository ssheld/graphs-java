package com.ssheld.Search;

import com.ssheld.AdjacencyListGraphs.Digraph;

/**
 * Author: Stephen Sheldon 4/5/2019
 *
 * Depth first search for a directed graph
 *
 */

public class DirectedDFS {
    private boolean marked[];

    // Find vertices in G that are reachable from S
    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    // Find vertices in G that are reachable from sources
    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int s : sources) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    // Check if V is reachable
    public boolean marked(int v) {
        return marked[v];
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }
}
