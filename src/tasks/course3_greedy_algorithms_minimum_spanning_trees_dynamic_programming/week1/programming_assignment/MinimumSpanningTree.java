package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week1.programming_assignment;

import tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week1.dependencies.Edge;
import tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week1.dependencies.Graph;
import tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week1.dependencies.Vertex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class MinimumSpanningTree {
    public static void main(String[] args) throws IOException {
        System.out.println(costOfMST("edges.txt"));
    }

    public static int costOfMST(String filename) throws IOException {
        Graph graph = init(filename);
        Vertex startVertex = graph.getVertexList().get(0);
        startVertex.setExplored(true);
        Queue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(Edge::getCost));
        edges.addAll(startVertex.getEdges());
        int result = 0;
        while (!edges.isEmpty()) {
            Edge currentEdge = edges.poll();
            if (!currentEdge.getLeft().isExplored()) {
                Vertex vertex = currentEdge.getLeft();
                vertex.setExplored(true);
                result += currentEdge.getCost();
                for (Edge edge : vertex.getEdges()) {
                    if (!edge.getRight().isExplored()) {
                        edges.add(edge);
                    }
                }
            } else if (!currentEdge.getRight().isExplored()) {
                Vertex vertex = currentEdge.getRight();
                vertex.setExplored(true);
                result += currentEdge.getCost();
                for (Edge edge : vertex.getEdges()) {
                    if (!edge.getRight().isExplored()) {
                        edges.add(edge);
                    }
                }
            }
        }

        return result;
    }

    public static Graph init(String filename) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("src", "resources", filename));
        List<Vertex> vertices = new ArrayList<>();
        for (int i = 1; i <= 500; i++) {
            vertices.add(new Vertex(i));
        }
        for (int i = 1; i < strings.size(); i++) {
            String string = strings.get(i);
            String[] split = string.split(" ");
            Vertex first = vertices.get(Integer.parseInt(split[0]) - 1);
            Vertex second = vertices.get(Integer.parseInt(split[1]) - 1);
            Edge edgeFirst = new Edge(first, second, Integer.parseInt(split[2]));
            Edge edgeSecond = new Edge(second, first, Integer.parseInt(split[2]));
            first.addEdge(edgeFirst);
            second.addEdge(edgeSecond);
        }
        return new Graph(vertices);
    }
}
