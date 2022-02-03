package tasks.course2_graph_search_and_data_structures.week2.programming_assignment;

import tasks.course2_graph_search_and_data_structures.week2.dependencies.Edge;
import tasks.course2_graph_search_and_data_structures.week2.dependencies.Graph;
import tasks.course2_graph_search_and_data_structures.week2.dependencies.Vertex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class DijkstraShortestPath {

    public static void countShortestPaths(String filename, int startVertex) throws IOException {
        Graph graph = init(filename);
        count(graph, startVertex);
        showAnswer(graph);
    }

    public static Graph init(String filename) throws IOException {
        List<String[]> strings = Files.readAllLines(Paths.get("src", "resources", filename)).stream()
                .map(string -> string.split("\t"))
                .collect(Collectors.toList());

        Graph graph = new Graph();
        for (int i = 1; i <= 200; i++) {
            graph.addVertex(new Vertex(i));
        }
        for (String[] string : strings) {
            for (int i = 1; i < string.length; i++) {
                Vertex leftVertex = graph.getVertices().get(parseInt(string[0]) - 1);
                String[] split = string[i].split(",");
                Vertex rightVertex = graph.getVertices().get(parseInt(split[0]) - 1);
                Edge edge = new Edge(leftVertex, rightVertex, parseInt(split[1]));
                graph.addEdge(edge);
            }
        }
        return graph;
    }

    public static void count(Graph graph, int startVertex) {
        Set<Vertex> setX = new HashSet<>();
        Queue<Vertex> queueX = new PriorityQueue<>();
        Vertex vertex = graph.getVertices().get(startVertex - 1);
        setX.add(vertex);
        while (setX.size() != graph.getVertices().size()) {
            List<Edge> processingEdges = new ArrayList<>();
            for (Edge edge : graph.getEdges()) {
                if (setX.contains(edge.getLeftVertex()) && !setX.contains(edge.getRightVertex())) {
                    processingEdges.add(edge);
                }
            }
            int currentDijkstraCoefficient = Integer.MAX_VALUE;
            Vertex currentDijkstraCoefficientVertex = null;
            for (Edge processingEdge : processingEdges) {
                if (processingEdge.getValue() + processingEdge.getLeftVertex().getDijkstraCoefficient() < currentDijkstraCoefficient) {
                    currentDijkstraCoefficientVertex = processingEdge.getRightVertex();
                    currentDijkstraCoefficient = processingEdge.getValue() + processingEdge.getLeftVertex().getDijkstraCoefficient();
                }
            }
            currentDijkstraCoefficientVertex.setDijkstraCoefficient(currentDijkstraCoefficient);
            setX.add(currentDijkstraCoefficientVertex);
        }
    }

    public static void showAnswer(Graph graph) {
        List<Vertex> vertices = graph.getVertices();
        System.out.print(vertices.get(7 - 1).getDijkstraCoefficient() + ",");
        System.out.print(vertices.get(37 - 1).getDijkstraCoefficient() + ",");
        System.out.print(vertices.get(59 - 1).getDijkstraCoefficient() + ",");
        System.out.print(vertices.get(82 - 1).getDijkstraCoefficient() + ",");
        System.out.print(vertices.get(99 - 1).getDijkstraCoefficient() + ",");
        System.out.print(vertices.get(115 - 1).getDijkstraCoefficient() + ",");
        System.out.print(vertices.get(133 - 1).getDijkstraCoefficient() + ",");
        System.out.print(vertices.get(165 - 1).getDijkstraCoefficient() + ",");
        System.out.print(vertices.get(188 - 1).getDijkstraCoefficient() + ",");
        System.out.print(vertices.get(197 - 1).getDijkstraCoefficient() + ",");
    }
}
