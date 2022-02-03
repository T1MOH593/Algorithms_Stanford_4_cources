package tasks.course2_graph_search_and_data_structures.week1.programming_assignment;

import tasks.course2_graph_search_and_data_structures.week1.dependencies.Edge;
import tasks.course2_graph_search_and_data_structures.week1.dependencies.Graph;
import tasks.course2_graph_search_and_data_structures.week1.dependencies.Vertex;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Integer.*;

public class SccCount {

    private static int t = 0;
    private static Vertex[] vertexArray = new Vertex[875714 + 1];
    private static int counter = 0;

    public static void sccCount(String filename) throws IOException {
        Graph graph = init(filename);
        reversedDfsLoop(graph);
        dfsLoop(graph);
    }

    public static Graph init(String filename) throws IOException {
        Graph graph = new Graph();
        for (int i = 1; i <= 875714; i++) {
            graph.addVertex(new Vertex(i));
        }
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("src", "resources", filename));
        while (bufferedReader.ready()) {
            String s = bufferedReader.readLine();
            String[] s1 = s.split(" ");
            Vertex leftVertex = graph.getVertices().get(parseInt(s1[0]) - 1);
            Vertex rightVertex = graph.getVertices().get(parseInt(s1[1]) - 1);
            Edge outgoingEdge = new Edge(leftVertex, rightVertex);
            leftVertex.getOutgoingEdges().add(outgoingEdge);
            graph.addEdge(outgoingEdge);
            rightVertex.getReversedEdges().add(new Edge(rightVertex, leftVertex));
        }
        return graph;
    }

    public static void reversedDfsLoop(Graph graph) {
        List<Vertex> vertices = graph.getVertices();
        for (int i = vertices.size() - 1; i >= 0; i--) {
            Vertex vertex = vertices.get(i);
            if (!vertex.isExplored()) {
                reversedDfs(graph, vertex);
            }
        }
    }

    public static void reversedDfs(Graph g, Vertex i) {
        i.setExplored(true);
        for (Edge edge : i.getReversedEdges()) {
            Vertex rightVertex = edge.getRightVertex();
            if (!rightVertex.isExplored()) {
                reversedDfs(g, rightVertex);
            }
        }
        vertexArray[++t] = i;
    }

    public static void dfsLoop(Graph graph) {
        List<Integer> cssSize = new ArrayList<>();
        for (int i = 875714; i > 0; i--) {
            Vertex vertex = vertexArray[i];
            if(vertex.isExplored()) {
                counter++;
                dfs(graph, vertex);
                cssSize.add(counter);
                counter = 0;
            }
        }
        cssSize.sort(Comparator.reverseOrder());
        for (int i = 0; i < 5; i++) {
            System.out.print(cssSize.get(i) + ",");
        }
    }

    public static void dfs(Graph g, Vertex i) {
        i.setExplored(false);
        for (Edge edge : i.getOutgoingEdges()) {
            Vertex rightVertex = edge.getRightVertex();
            if (rightVertex.isExplored()) {
                counter++;
                dfs(g, rightVertex);
            }
        }
    }
}
