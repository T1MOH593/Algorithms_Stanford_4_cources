package tasks.course1_divide_and_conquer.week4;

import tasks.course1_divide_and_conquer.week4.dependencies.Edge;
import tasks.course1_divide_and_conquer.week4.dependencies.Graph;
import tasks.course1_divide_and_conquer.week4.dependencies.Vertex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Math.*;

public class MinCutGraph {

    private static int counter = 0;

    private static Graph init(String fileName) throws IOException {
        List<String> fileList1 = Files.readAllLines(Paths.get("src", "resources", fileName));
        List<String[]> fileList2 = new ArrayList<>();
        Set<Edge> edgeSet = new HashSet<>();
        List<Vertex> vertexList = new ArrayList<>();
        for (int i = 0; i < fileList1.size(); i++) {
            String s = fileList1.get(i).replaceAll(" ", "\t");
            fileList1.remove(i);
            fileList1.add(i, s);
            fileList2.add(fileList1.get(i).split("\t"));
        }

        for (String[] strings : fileList2) {
            Vertex vertex = new Vertex();
            vertex.setValue(parseInt(strings[0]));
            vertexList.add(vertex);
        }

        for (String[] strings : fileList2) {
            for (int i = 1; i < strings.length; i++) {
                Vertex left = new Vertex();
                Vertex right = new Vertex();
                left.setValue(min(parseInt(strings[0]), parseInt(strings[i])));
                right.setValue(max(parseInt(strings[0]), parseInt(strings[i])));
                Edge edge = new Edge();
                edge.setLeft(left);
                edge.setRight(right);
                edgeSet.add(edge);
            }
        }
        counter = (int) Math.pow(vertexList.size(), 2);

        return new Graph(new ArrayList<>(edgeSet), vertexList);
    }

    private static Graph contraction(Graph graph) {
        List<Edge> edgeList = graph.getEdgeList();
        List<Vertex> vertexList = graph.getVertexList();
        int size = edgeList.size();
        for (int j = 0; j < size && vertexList.size() > 2; j++) {
            int randomIndex = (int) floor(random() * size);
            Edge edge = edgeList.get(randomIndex);
            edgeList.remove(randomIndex);
            j--;
            size--;
            vertexList.remove(edge.getRight());
            for (int i = 0; i < size; i++) {
                Edge edge1 = edgeList.get(i);
                if (edge.getRight().equals(edge1.getLeft())) {
                    edge1.setLeft(edge.getLeft());
                }
                if (edge.getRight().equals(edge1.getRight())) {
                    edge1.setRight(edge.getLeft());
                }
                if (edge1.getRight().equals(edge1.getLeft())) {
                    edgeList.remove(i--);
                    size--;
                }
            }
        }

        return graph;
    }

    private static int interpretResult(Graph graph) {
        return graph.getEdgeList().size();
    }

    public static int minCut(String fileName) throws IOException {
        int min = Integer.MAX_VALUE;
        Graph init = init(fileName);
        for (long i = 0; i < counter; i++) {
            init = init(fileName);
            Graph contraction = contraction(init);
            int result = interpretResult(contraction);
            min = Math.min(min, result);
            System.out.println(i);
        }
        return min;
    }
}
