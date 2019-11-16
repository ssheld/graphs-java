package com.ssheld.adjacencylistgraphs;

import java.util.Iterator;

/**
 * Author: Stephen Sheldon 4/29/2019
 */

public abstract class Graph {
  protected int numVertices;                      // Number of vertices
  protected int numEdges;                         // Number of edges

  /**
   * Constructor for Graph object, takes in number of vertices and number of edges
   * @param numVertices number of vertices in the graph
   * @param numEdges number of edges in the graph
   */
  public Graph(int numVertices, int numEdges) {
    this.numEdges = numEdges;
    this.numVertices = numVertices;
  }

  /**
   * This method returns the number of vertices in the graph
   * @return number of vertices in graph
   */
  public int getNumVertices() {
    return numVertices;
  }

  /**
   * This method returns the number of edges in the graph
   * @return number of edges in graph
   */
  public int getNumEdges() {
    return numEdges;
  }

  public Iterable<Integer> adj(int v) {
    return new Iterable<Integer>() {
      @Override
      public Iterator<Integer> iterator() {
        return null;
      }
    };
  }

  public void addEdge(int v, int w) {}

  public void printGraph() {}
}
