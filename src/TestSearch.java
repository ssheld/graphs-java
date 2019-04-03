import com.ssheld.Graph.Graph;
import com.ssheld.Search.*;

import java.util.*;

/**
 * Author: Stephen Sheldon 3/24/2019
 *
 * Returns all the vertices connected to an user inputted vertex and tells the user
 * whether or not the graph is connected.
 */

public class TestSearch {

    public static void main(String[] args) {
        int source;
        int choice;

        Graph g = new Graph();

        System.out.println("You have the following graph:");
        g.printAdjList();

        Scanner scan = new Scanner(System.in);

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

            if (choice == 1) {
                System.out.println("Please enter the vertex that you would like me to find all connected vertices to");
                source = scan.nextInt();
                DepthFirstSearch search = new DepthFirstSearch(g, source);
                System.out.println("Doing a depth first search...");

                for (int i = 0; i < g.V(); i++) {
                    if (search.marked(i))
                        System.out.printf("%d ", i);
                }
                System.out.println();
                if (search.count() != g.V())
                    System.out.println("NOT CONNECTED");
                else
                    System.out.println("CONNECTED");
            }
            else if (choice == 2) {
                DepthFirstPaths dfp = new DepthFirstPaths(g, 0);

                for (int v = 0; v < g.V(); v++) {
                    // Check and see if we have a path to vertex v
                    // and we need to check to make sure v is our source
                    if (dfp.hasPathTo(v)) {
                        System.out.printf("0 to %d: ", v);
                        // If we do let's iterate through it
                        Stack<Integer> s = dfp.pathTo(v);
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
                for (int v = 0; v < g.V(); v++) {
                    if (bfp.hasPathTo(v)) {
                        System.out.printf("0 to %d: ", v);
                        // If we do let's iterate through it
                        Stack<Integer> s = bfp.pathTo(v);
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
                for (int i = 0; i < g.V(); i++) {
                    components[cc.id(i)].add(i);
                }

                for (int i = 0; i < n; i++) {
                    for (int v : components[i]) {
                        System.out.printf(v + " ");
                    }
                    System.out.println("");
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
        } while (choice != 0);
    }
}
