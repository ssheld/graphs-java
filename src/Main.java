import com.ssheld.Graph.Graph;
import com.ssheld.Search.DepthFirstSearch;

import java.util.Scanner;

/**
 * Author: Stephen Sheldon 3/24/2019
 */

public class Main {

    public static void main(String[] args) {
        int source;
        Graph g = new Graph();
        g.printAdjList();;

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the source vertex that you would like me to find all connected vertices");
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
}
