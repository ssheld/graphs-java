package com.ssheld.utils;

import com.ssheld.adjacencylistgraphs.Graph;

/**
 * Author: Stephen Sheldon 11/16/19
 **/
public class GraphUtils {

    /**
     * Compute the degree of a specific vertex v.
     * @param G The graph object
     * @param v The vertex that we wish to compute the degree of
     * @return
     */
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v))
            degree++;
        return degree;
    }
}
