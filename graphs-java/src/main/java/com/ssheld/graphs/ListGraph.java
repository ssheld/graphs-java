package com.ssheld.graphs;

import java.util.LinkedList;

public class ListGraph extends Graph {

    private LinkedList<Integer>[] adj;

    public ListGraph(int numVertices) {
        super(numVertices, 0);

        adj = new LinkedList[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }
}
