package com.ssheld.utils;

import com.ssheld.graphs.Graph;

public class GraphUtils {

    public static int degree(Graph g, int v) {
        int degree = 0;
        for (int w : g.adj(v))
            degree++;
        return degree;
    }

    public static int maxDegree(Graph g) {
        int max = 0;
        for (int v = 0; v < g.getNumVertices(); v++) {
            if (degree(g, v) > max )
                max = degree(g, v);
        }
        return max;
    }

    public static int averageDegree(Graph g) {
        return 2 * g.getNumEdges() / g.getNumVertices();
    }

    public static int numberOfSelfLoops(Graph g) {
        int count = 0;
        for (int v = 0; v < g.getNumVertices(); v++) {
            for (int w : g.adj(v)) {
                if (v == w)
                    count++;
            }
        }
        return count;
    }

}
