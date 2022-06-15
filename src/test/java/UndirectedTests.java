import com.ssheld.graphs.ListGraph;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UndirectedTests {

    ListGraph myListGraph;

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
        myListGraph = new ListGraph(0);
        Scanner scan = new Scanner(System.in);
        Scanner fin;
        fileName = "smallGraph.txt";
        try {
            fin = new Scanner(new File(fileName));
            vCount = Integer.parseInt(fin.nextLine());
            eCount = Integer.parseInt(fin.nextLine());
            // User has chosen to use an adjacency list
            myListGraph = new ListGraph(vCount);
            for (int i = 0; i < eCount; i++) {
                v = fin.nextInt();
                w = fin.nextInt();
                myListGraph.addEdge(v, w);
            }


                System.out.println("You have the following graph:");
                myListGraph.printGraph();

            } catch(FileNotFoundException e){
                System.out.println("Sorry, the file you specified could not be found.");
            }
        }
    }
