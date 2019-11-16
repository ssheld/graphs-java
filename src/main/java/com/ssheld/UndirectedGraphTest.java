package com.ssheld;

import com.ssheld.AdjacencyListGraphs.Graph;
import com.ssheld.AdjacencyListGraphs.ListGraph;
import com.ssheld.AdjacencyListGraphs.MatrixGraph;
import com.ssheld.Search.Bipartite;
import com.ssheld.Search.BreadthFirstPaths;
import com.ssheld.Search.ConnectedComponents;
import com.ssheld.Search.Cycle;
import com.ssheld.Search.DepthFirstPaths;
import com.ssheld.Search.DepthFirstSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Author: Stephen Sheldon 3/24/2019
 *
 * Returns all the vertices connected to an user inputted vertex and tells the user
 * whether or not the graph is connected.
 */

public class UndirectedGraphTest {

    public static void main(String[] args) {
        // Source Vertex
        int source;
        // User menu choice
        int choice;
        // User choice to use either adj list or adj matrix
        int graphType;
        // Number of vertices in graph
        int vCount;
        // Number of edges in graph
        int eCount;
        // Edge values scanner from file
        int v, w;
        // File name specified by user to read graph data from
        String fileName;

        Graph g = new ListGraph(0);

        Scanner scan = new Scanner(System.in);
        Scanner fin;


        System.out.println("Please specify the name of the file you wish to generate a graph from");
        fileName = scan.next();

        System.out.println("Would you like to create a graph using an");
        System.out.println("1. Adjacency List");
        System.out.println("2. Adjacency Matrix");
        graphType = scan.nextInt();

        try {
            fin = new Scanner(new File(fileName));
            vCount = Integer.parseInt(fin.nextLine());
            eCount = Integer.parseInt(fin.nextLine());
            // User has chosen to use an adjacency list
            if (graphType == 1) {
                g = new ListGraph(vCount);
                for (int i = 0; i < eCount; i++) {
                    v = fin.nextInt();
                    w = fin.nextInt();
                    g.addEdge(v, w);
                }
            }
            else {
              g = new MatrixGraph(vCount);
              for (int i = 0; i < eCount; i++) {
                v = fin.nextInt();
                w = fin.nextInt();
                g.addEdge(v,w);
              }
            }

            System.out.println("You have the following graph:");
            g.printGraph();

        } catch (FileNotFoundException e) {
            System.out.println("Sorry, the file you specified could not be found.");
        }

        if (graphType == 2) {
            System.out.println();
            System.out.println("Ending program, graphs represented by adjacency matrix's are currently not supported. Sorry!");
            System.exit(0);
        }

        System.out.println("Which of the following would you like to do with the graph?");
        do {
            System.out.println("1. Find all vertices connected to a specific vertex");
            System.out.println("2. Print path to each vertex");
            System.out.println("3. Find the shortest path to each vertex");
            System.out.println("4. Print all members of each connected component");
            System.out.println("5. Check if the graph is acyclic");
            System.out.println("6. Check if the graph is bipartite (two-colorable)");
            System.out.println("0. Exit the program");
            choice = scan.nextInt();
            System.out.println();

            if (choice == 1) {
                System.out.println("Please enter the vertex that you would like me to find all connected vertices to");
                source = scan.nextInt();
                DepthFirstSearch search = new DepthFirstSearch(g, source);
                System.out.println("Doing a depth first search...");

                for (int i = 0; i < g.getNumVertices(); i++) {
                    if (search.marked(i))
                        System.out.printf("%d ", i);
                }
                System.out.println();
                if (search.count() != g.getNumVertices())
                    System.out.println("NOT CONNECTED");
                else
                    System.out.println("CONNECTED");
            }
            else if (choice == 2) {
                DepthFirstPaths dfp = new DepthFirstPaths(g, 0);

                for (int i = 0; i < g.getNumVertices(); i++) {
                    // Check and see if we have a path to vertex v
                    // and we need to check to make sure v is our source
                    if (dfp.hasPathTo(i)) {
                        System.out.printf("0 to %d: ", i);
                        // If we do let's iterate through it
                        Stack<Integer> s = dfp.pathTo(i);
                        System.out.printf("%d", s.pop());
                        Iterator itr = s.iterator();
                        while (itr.hasNext()) {
                            System.out.printf("-%d", s.pop());
                        }
                    }
                    System.out.println();
                }
            }
            else if (choice == 3) {
                BreadthFirstPaths bfp = new BreadthFirstPaths(g, 0);
                for (int i = 0; i < g.getNumVertices(); i++) {
                    if (bfp.hasPathTo(i)) {
                        System.out.printf("0 to %d: ", i);
                        // If we do let's iterate through it
                        Stack<Integer> s = bfp.pathTo(i);
                        System.out.printf("%d", s.pop());
                        Iterator itr = s.iterator();
                        while (itr.hasNext()) {
                            System.out.printf("-%d", s.pop());
                        }
                    }
                    System.out.println();
                }
            }
            else if (choice == 4) {
                ConnectedComponents cc = new ConnectedComponents(g);

                int n = cc.count();
                System.out.println(n + " Components");

                PriorityQueue<Integer>[] components;
                components = new PriorityQueue[n];
                for (int i = 0; i < n; i++) {
                    components[i] = new PriorityQueue<>();
                }
                for (int i = 0; i < g.getNumVertices(); i++) {
                    components[cc.id(i)].add(i);
                }

                for (int i = 0; i < n; i++) {
                    for (int vertex : components[i]) {
                        System.out.printf(vertex + " ");
                    }
                    System.out.println();
                }
            }
            else if (choice == 5) {
                Cycle c = new Cycle(g);
                if (c.hasCycle()) {
                    System.out.println("This graph contains cycles.");
                }
                else {
                    System.out.println("This graph contains no cycles.");
                }
            }
            else if (choice == 6) {
                Bipartite bipartiteGraph = new Bipartite(g);
                if (bipartiteGraph.isBipartite()) {
                    System.out.println("Yes this graph is bipartite! It is two-colorable.");
                }
                else {
                    System.out.println("No this graph is NOT bipartite! It is not two-colorable.");
                }
            }
            System.out.println();
        } while (choice != 0);
    }
}
