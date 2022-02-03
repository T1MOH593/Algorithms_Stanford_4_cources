package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week2.programming_assignment;

import tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week2.dependencies.Edge;
import tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week2.dependencies.UnionFind;
import tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week2.dependencies.Vertex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Clustering1 {

    public static int maxSpacingKClustering(String filename, int k) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("src", "resources", filename));
        int numberOfVertices = Integer.parseInt(strings.get(0));
        UnionFind unionFind = new UnionFind(numberOfVertices);
        Edge[] edges = new Edge[strings.size() - 1];
        for (int i = 0; i < edges.length; i++) {
            String[] split = strings.get(i + 1).split(" ");
            Edge edge = new Edge(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            edges[i] = edge;
        }
        Arrays.sort(edges, Comparator.comparingInt(Edge::getCost));
        int counter = 0;
        int i = 0;
        while (counter < numberOfVertices - k) {
            Edge currentEdge = edges[i++];
            Vertex1 firstVertex = unionFind.find(currentEdge.getLeft());
            Vertex1 secondVertex = unionFind.find(currentEdge.getRight());
            if (firstVertex != secondVertex) {
                unionFind.union(firstVertex, secondVertex);
                counter++;
            }
        }
        int result = Integer.MAX_VALUE;
        while (i < edges.length) {
            Edge edge = edges[i++];
            if (unionFind.find(edge.getLeft()) != unionFind.find(edge.getRight())) {
                result = Math.min(result, edge.getCost());
            }
        }
        return result;
    }
}
