package com.ssheld.adjacencylistgraphs;

/**
 * Author: Stephen Sheldon 4/29/2019
 */

public class MatrixGraph extends Graph {

  private int[][] adjMatrix;

  /**
   * Constructor to great a graph using an adjacency matrix
   * @param numVertices The number of vertices in the graph
   */
  public MatrixGraph(int numVertices) {
    super(numVertices, 0);

    // Create our adjacency matrix
    adjMatrix = new int [numVertices][numVertices];

    // Set default values for adjacency matrix using integer min value
    for (int i = 0; i < numVertices; i++) {
      for (int j = 0; j < numVertices; j++) {
        adjMatrix[i][j] = 0;
      }
    }
  }

  /**
   * Add an edge to our adjacency list
   * @param to the vertex we're going to
   * @param from the vertex we're coming from
   */
  @Override
  public void addEdge(int to, int from) {

    try {
      // Initialize this edge to 1 to show that it exists (non-weighted edges)
      adjMatrix[to][from] = 1;
    } catch (ArrayIndexOutOfBoundsException aioobe) {
      System.out.println("Array is currently out of bounds while trying to add an edge");
    }
  }

  /**
   * Prints graph out in an adjacency matrix representation
   */
  @Override
  public void printGraph() {
    for (int i = 0; i < numVertices; i++) {
      for (int j = 0; j < numVertices; j++) {
        System.out.printf(" %d", adjMatrix[i][j]);
      }
      System.out.println();
    }
  }
}
