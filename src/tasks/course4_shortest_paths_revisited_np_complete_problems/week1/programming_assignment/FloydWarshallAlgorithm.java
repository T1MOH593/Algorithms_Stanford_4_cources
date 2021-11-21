package tasks.course4_shortest_paths_revisited_np_complete_problems.week1.programming_assignment;

import tasks.course4_shortest_paths_revisited_np_complete_problems.week1.dependencies.Edge;
import tasks.course4_shortest_paths_revisited_np_complete_problems.week1.dependencies.Graph;
import tasks.course4_shortest_paths_revisited_np_complete_problems.week1.dependencies.Vertex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.Integer.parseInt;

public class FloydWarshallAlgorithm {

    private static int[][][] matrix;

    public static int algorithm(String filename) throws IOException {
        Graph graph = init(filename);
        drawOneColumnOfBaseCases(graph, 0);

        for (int k = 1; k < matrix[0].length; k++) {
            drawOneColumnOfBaseCases(graph, 1);
            for (int i = 1; i < matrix[0].length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    boolean flag = false;
                    int min;
                    if (matrix[0][k][j] == Integer.MAX_VALUE ||
                            matrix[0][i][k] == Integer.MAX_VALUE) {
                        flag = true;
                    }
                    if (flag) {
                        min = matrix[0][i][j];
                    } else {
                        min = Math.min(matrix[0][i][j],
                                matrix[0][k][j] + matrix[0][i][k]);
                    }
                    matrix[1][i][j] = min;
                }
            }
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[1][i][i] < 0) {
                    System.out.println("negative cycle");
                }
            }
            copyRightColumnToLeft();

        }
        int min = getMin();
        return min;
    }


    public static Graph init(String filename) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(filename));
        Graph graph = new Graph();
        String[] split = strings.get(0).split(" ");
        int amountOfVertices = parseInt(split[0]);
        for (int i = 0; i < amountOfVertices; i++) {
            graph.addVertex(new Vertex());
        }
        matrix = new int[2][amountOfVertices + 1][amountOfVertices + 1];

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

    private static void drawOneColumnOfBaseCases(Graph graph, int k) {
        for (int i = 1; i < matrix[k].length; i++) {
            for (int j = 1; j < matrix[k].length; j++) {
                Vertex tail = graph.getVertices().get(i - 1);
                Vertex head = graph.getVertices().get(j - 1);
                boolean flag = true;
                if (i != j) {
                    for (Edge outgoingEdge : tail.getOutgoingEdges()) {
                        if (outgoingEdge.getHead() == head) {
                            matrix[k][i][j] = outgoingEdge.getCost();
                            flag = false;
                            break;
                        }
                    }
                }
                if (i != j && flag) {
                    matrix[k][i][j] = Integer.MAX_VALUE;
                }
                if (i == j) {
                    matrix[k][i][j] = 0;
                }
            }
        }
    }

    private static void copyRightColumnToLeft() {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][i][j] = matrix[1][i][j];
            }
        }
    }

    private static int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < matrix[0].length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                int value = matrix[0][i][j];
                if (value < min) {
                    min = value;
                }
            }
        }
        return min;
    }
}
