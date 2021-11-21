package tasks.course4_shortest_paths_revisited_np_complete_problems.week1.programming_assignment;

import tasks.course4_shortest_paths_revisited_np_complete_problems.week1.dependencies.Edge;
import tasks.course4_shortest_paths_revisited_np_complete_problems.week1.dependencies.Graph;
import tasks.course4_shortest_paths_revisited_np_complete_problems.week1.dependencies.Vertex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Integer.parseInt;

public class JonsonsAlgorithm {

    private static int[][] matrix;
    
    public static void algorithm(String filename) throws IOException {
        Graph graph = init(filename);
        Vertex initVertex = new Vertex();
        graph.addVertex(initVertex);
        initVertex.setNumber(graph.getVertices().size());
        for (int i = 0; i < graph.getVertices().size(); i++) {
            Vertex headVertex = graph.getVertices().get(i);
            Edge edge = new Edge(initVertex, headVertex, 0);
            graph.addEdge(edge);
            initVertex.addOutgoingEdge(edge);
            headVertex.addIngoingEdge(edge);
        }
        int[][] localMatrix = bellmanFordAlgorithm(initVertex, graph);

        for (int i = 0; i < graph.getVertices().size() - 1; i++) {
            Vertex vertex = graph.getVertices().get(i);
            int value = localMatrix[localMatrix.length - 1][i + 1];
            vertex.setWeight(value);
        }

        for (Edge edge : graph.getEdges()) {
            int currentCost = edge.getCost();
            Vertex head = edge.getHead();
            Vertex tail = edge.getTail();
            edge.setCost(currentCost + tail.getWeight() - head.getWeight());
        }

        for (int i = 0; i < graph.getVertices().size() - 1; i++) {
            Vertex currentVertex = graph.getVertices().get(i);
            dijkstraAlgorithm(graph, currentVertex);
        }
    }

    public static void dijkstraAlgorithm(Graph graph, Vertex startVertex) {

    }

    private static int[][] bellmanFordAlgorithm(Vertex initVertex, Graph graph) {
        int[][] localMatrix = new int[graph.getVertices().size() + 2][graph.getVertices().size() + 1];

        for (int i = 2; i < localMatrix.length; i++) {
            for (int j = 1; j < localMatrix[i].length; j++) {
                int firstValue = localMatrix[i - 1][j];
                Vertex vertex = graph.getVertices().get(j - 1);
                for (Edge ingoingEdge : vertex.getIngoingEdges()) {
                    int secondValue = localMatrix[i - 1][ingoingEdge.getTail().getNumber()] + ingoingEdge.getCost();
                    firstValue = Math.min(firstValue, secondValue);
                }
                localMatrix[i][j] = firstValue;
            }
        }

        for (int j = 0; j < localMatrix[0].length; j++) {
            int last = localMatrix[localMatrix.length - 1][j];
            int prev = localMatrix[localMatrix.length - 2][j];
            if (last != prev) {
                System.out.println("negative cycle");
            }
        }

        return localMatrix;
    }
    
    private static Graph init(String filename) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(filename));
        Graph graph = new Graph();
        String[] split = strings.get(0).split(" ");
        int amountOfVertices = parseInt(split[0]);
        for (int i = 0; i < amountOfVertices; i++) {
            Vertex vertex = new Vertex();
            vertex.setNumber(i + 1);
            graph.addVertex(vertex);
        }
        matrix = new int[amountOfVertices + 1][amountOfVertices + 1];

        for (int i = 1; i < strings.size(); i++) {
            String[] s = strings.get(i).split(" ");
            int numberOfTailVertex = parseInt(s[0]);
            int numberOfHeadVertex = parseInt(s[1]);
            int cost = parseInt(s[2]);
            Vertex tailVertex = graph.getVertices().get(numberOfTailVertex - 1);
            Vertex headVertex = graph.getVertices().get(numberOfHeadVertex - 1);
            Edge edge = new Edge(tailVertex, headVertex, cost);
            graph.addEdge(edge);
            tailVertex.addOutgoingEdge(edge);
            headVertex.addIngoingEdge(edge);
        }
        return graph;
    }
}
