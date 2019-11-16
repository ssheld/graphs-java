package com.ssheld.Search;

import com.ssheld.AdjacencyListGraphs.Digraph;

import java.util.Stack;

/**
 * Author: Stephen Sheldon 4/29/2019
 *
 * Checks for directed cycles on a digraph
 */

public class DirectedCycle {
  private boolean[] marked;
  private int[] edgeTo;
  private Stack<Integer> cycle; // Vertices on a cycle (If one exists)
  private boolean[] onStack;    // Vertices on function call stack

  /**
   * Constructor for DirectedCycle
   * @param G digraph object
   */
  public DirectedCycle(Digraph G) {
    onStack = new boolean[G.getNumVertices()];
    edgeTo = new int[G.getNumVertices()];
    marked = new boolean[G.getNumVertices()];

    for (int v = 0; v < G.getNumVertices(); v++) {
      if (!marked[v]) {
        dfs(G, v);
      }
    }
  }

  /**
   * Depth first search to check for directed cycles
   * @param G digraph
   * @param v vertex we are starting our depth-first-search from
   */
  private void dfs(Digraph G, int v) {
    onStack[v] = true;
    marked[v] = true;
    for (int w : G.adj(v)) {
      if (this.hasCycle()) {
        return;
      } else if (!marked[w]) {
        edgeTo[w] = v;
        dfs(G, w);
      } else if (onStack[w]) {
        cycle = new Stack<Integer>();
        for (int x = v; x != w; x = edgeTo[x]) {
          cycle.push(x);
        }
        cycle.push(w);
        cycle.push(v);
      }
    }
    onStack[v] = false;
  }

  /**
   * Check if cycle stack is null
   * @return boolean value whether or not digraph has cycle
   */
  public boolean hasCycle() {
    return cycle != null;
  }

  /**
   * Returns an iterable for our Integer stack
   * @return iterable for our Integer stack
   */
  public Iterable<Integer> cycle() {
    return cycle;
  }

}
