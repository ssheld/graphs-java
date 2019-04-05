import com.ssheld.Graph.Digraph;

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
        int vCount, eCount, v, w;
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
            System.out.println("0. Quit the program.");

            choice = scan.nextInt();


            if (choice == 1) {
                for (int i = 0; i < G.V(); i++) {
                    System.out.printf("%d :", i);
                    for (int j : G.adj(i)) {
                        System.out.printf(" %d ", j);
                    }
                    System.out.println("");
                }
            }
        } while (choice != 0);
    }
}
