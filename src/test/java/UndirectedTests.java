import com.ssheld.graphs.Graph;
import com.ssheld.graphs.ListGraph;
import com.ssheld.search.DepthFirstSearch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UndirectedTests {

    ListGraph myUnconnectedListGraph;
    ListGraph myConnectedListGraph;

    // Source Vertex
    int source;
    // Number of vertices in graph
    int vCount;
    // Number of edges in graph
    int eCount;
    // Edge values scanner from file
    int v, w;
    // File name specified by user to read graph data from
    String fileName;

    @BeforeEach
    void setup() {
        myUnconnectedListGraph = new ListGraph(0);
        Scanner scan = new Scanner(System.in);
        Scanner fin;
        fileName = "unconnectedSmallGraph.txt";
        try {
            fin = new Scanner(new File(fileName));
            vCount = Integer.parseInt(fin.nextLine());
            eCount = Integer.parseInt(fin.nextLine());
            // User has chosen to use an adjacency list
            myUnconnectedListGraph = new ListGraph(vCount);
            for (int i = 0; i < eCount; i++) {
                v = fin.nextInt();
                w = fin.nextInt();
                myUnconnectedListGraph.addEdge(v, w);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Sorry, the file you specified could not be found.");
        }

        myConnectedListGraph = new ListGraph(0);
        scan = new Scanner(System.in);
        fileName = "connectedSmallGraph.txt";
        try {
            fin = new Scanner(new File(fileName));
            vCount = Integer.parseInt(fin.nextLine());
            eCount = Integer.parseInt(fin.nextLine());
            // User has chosen to use an adjacency list
            myConnectedListGraph = new ListGraph(vCount);
            for (int i = 0; i < eCount; i++) {
                v = fin.nextInt();
                w = fin.nextInt();
                myConnectedListGraph.addEdge(v, w);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Sorry, the file you specified could not be found.");
        }
    }

    @Test
    void depthFirstSearchUnconnectedGraph() {
        System.out.println("You have the following unconnected graph:");
        myUnconnectedListGraph.printGraph();

        System.out.println("Finding all connected vertices to 0");
        DepthFirstSearch dfs = new DepthFirstSearch(myUnconnectedListGraph, 0);
        for (int v = 0; v < myUnconnectedListGraph.getNumVertices(); v++) {
            if (dfs.marked(v)) {
                System.out.printf("%d ", v);
            }
        }

        System.out.printf("\n");

        // Check if graph is connected
        assertEquals(false, dfs.count() == myUnconnectedListGraph.getNumVertices());
    }

    @Test
    void depthFirstSearchConnectedGraph() {
        System.out.println("You have the following connected graph:");
        myConnectedListGraph.printGraph();

        System.out.println("Finding all connected vertices to 0");
        DepthFirstSearch dfs = new DepthFirstSearch(myConnectedListGraph, 0);
        for (int v = 0; v < myConnectedListGraph.getNumVertices(); v++) {
            if (dfs.marked(v)) {
                System.out.printf("%d ", v);
            }
        }

        System.out.printf("\n");

        // Check if graph is connected
        assertEquals(true, dfs.count() == myConnectedListGraph.getNumVertices());
    }
}
