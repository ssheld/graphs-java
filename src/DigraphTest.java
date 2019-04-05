import com.ssheld.Graph.Digraph;
import com.ssheld.Search.DirectedDFS;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Author: Stephen Sheldon 4/5/2019
 *
 * Class to test digraph functionality
 *
 */

public class DigraphTest {

    public static void main(String[] args) {

        Scanner fin;
        Scanner scan = new Scanner(System.in);
        String fileName;
        int vCount, eCount, v, w, source, target;
        Digraph G = new Digraph(1);

        System.out.println("Please specify the name of the file you wish to generate a graph from");
        fileName = scan.next();

        try {
            fin = new Scanner(new File(fileName));
            vCount = Integer.parseInt(fin.nextLine());
            eCount = Integer.parseInt(fin.nextLine());
            G = new Digraph(vCount);
            for (int i = 0; i < eCount; i++) {
                v = fin.nextInt();
                w = fin.nextInt();
                G.addEdge(v, w);
            }



        } catch (FileNotFoundException e) {
            System.out.println("The file you entered could not be found!");
        }

        int choice;
        System.out.println("Please enter your choice.");
        do {
            System.out.println("1. Print the graph as scanner in");
            System.out.println("2. Reverse the Digraph and print the result");
            System.out.println("3. Check if there is a directed path from source s to a given target vertex v");
            System.out.println("0. Quit the program.");

            choice = scan.nextInt();

            System.out.println();

            if (choice == 1) {
                for (int i = 0; i < G.V(); i++) {
                    System.out.printf("%d :", i);
                    for (int j : G.adj(i)) {
                        System.out.printf(" %d ", j);
                    }
                    System.out.println("");
                }
            }
            else if (choice == 2) {
                Digraph reversedGraph = G.reverse();
                for (int i = 0; i < reversedGraph.V(); i++) {
                    System.out.printf("%d :", i);
                    for (int j : reversedGraph.adj(i)) {
                        System.out.printf(" %d ", j);
                    }
                    System.out.println("");
                }
            }
            else if (choice == 3) {
                System.out.println("Please enter the source vertex");
                source = scan.nextInt();
                System.out.println("Please enter the target vertex");
                target = scan.nextInt();
                DirectedDFS dDFS = new DirectedDFS(G, source);

                if (dDFS.marked(target)) {
                    System.out.printf("Yes you can reach %d from %d%n", target, source);
                }
                else {
                    System.out.printf("No you can not reach %d from %d%n", target, source);
                }
            }

            System.out.println();
        } while (choice != 0);
    }
}
