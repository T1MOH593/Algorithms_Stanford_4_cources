package tasks.course4_shortest_paths_revisited_np_complete_problems.week4.programming_assignment;

import tasks.course2_graph_search_and_data_structures.week1.dependencies.Edge;
import tasks.course4_shortest_paths_revisited_np_complete_problems.week4.dependencies.Vertex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TwoSatAlgorithm {

    private static int t = 0;
    private static Vertex[] vertexArray;
    private static int leader;

    public static boolean twoSatAlgorithm(String filename) throws IOException {
        List<Vertex> vertices = init(filename);
        reversedDfsLoop(vertices);
        dfsLoop(vertices);

        for (int i = 0; i < vertices.size(); i++) {
            Vertex vertex = vertices.get(i);
            int indexOfNumber1 = getIndexOfNumber(vertex.getNumber(), vertices.size() / 2);
            int indexOfNumber2 = getIndexOfNumber(vertex.getNumber() * -1, vertices.size() / 2);
            int numberOfParentVertex1 = vertices.get(indexOfNumber1).getNumberOfParentVertex();
            int numberOfParentVertex2 = vertices.get(indexOfNumber2).getNumberOfParentVertex();
            if (numberOfParentVertex1 == numberOfParentVertex2) {
                return false;
            }
        }
        return true;
    }

    private static void dfsLoop(List<Vertex> vertices) {
        for (int i = vertexArray.length - 1; i > 0; i--) {
            Vertex vertex = vertexArray[i];
            if(vertex.isExplored()) {
                leader = vertex.getNumber();
                vertex.setNumberOfParentVertex(leader);
                dfs(vertices, vertex);
            }
        }
    }

    private static void dfs(List<Vertex> vertices, Vertex vertex) {
        vertex.setExplored(false);
        for (Vertex rightVertex : vertex.getDestinationVertices()) {
            if (rightVertex.isExplored()) {
                rightVertex.setNumberOfParentVertex(leader);
                dfs(vertices, rightVertex);
            }
        }
    }


    private static void reversedDfsLoop(List<Vertex> vertices) {
        for (int i = vertices.size() - 1; i >= 0; i--) {
            Vertex vertex = vertices.get(i);
            if (!vertex.isExplored()) {
                reversedDfs(vertices, vertex);
            }
        }
    }

    private static void reversedDfs(List<Vertex> vertices, Vertex vertex) {
        vertex.setExplored(true);
        for (Vertex originVertex : vertex.getOriginVertices()) {
            if (!originVertex.isExplored()) {
                reversedDfs(vertices, originVertex);
            }
        }
        vertexArray[++t] = vertex;
    }

    public static List<Vertex> init(String filename) throws IOException {
        leader = 0;
        t = 0;
        List<String> strings = Files.readAllLines(Paths.get(filename));
        int numberOfVertices = Integer.parseInt(strings.get(0));
        vertexArray = new Vertex[numberOfVertices * 2 + 1];
        List<Vertex> vertices = new ArrayList<>(numberOfVertices);
        for (int i = 1; i <= numberOfVertices; i++) {
            vertices.add(new Vertex(i));
            vertices.add(new Vertex(i * -1));
        }
        vertices.sort((v1, v2) -> {
            int n1 = v1.getNumber();
            int n2 = v2.getNumber();
            if (n1 < 0 && n2 < 0) {
                return n2 - n1;
            } else {
                return n1 - n2;
            }
        });
        for (int i = 1; i < strings.size(); i++) {
            String[] split = strings.get(i).split(" ");
            int i1 = Integer.parseInt(split[0]);
            int i2 = Integer.parseInt(split[1]);
            int i1Index = getIndexOfNumber(i1, numberOfVertices);
            int i2Index = getIndexOfNumber(i2, numberOfVertices);
            int i1ReversedIndex = getIndexOfNumber(-i1, numberOfVertices);
            int i2ReversedIndex = getIndexOfNumber(-i2, numberOfVertices);

            Vertex originVertex1 = vertices.get(i1ReversedIndex);
            Vertex destinationVertex1 = vertices.get(i2Index);
            Vertex originVertex2 = vertices.get(i2ReversedIndex);
            Vertex destinationVertex2 = vertices.get(i1Index);

            originVertex1.addDestinationVertex(destinationVertex1);
            destinationVertex1.addOriginVertex(originVertex1);

            originVertex2.addDestinationVertex(destinationVertex2);
            destinationVertex2.addOriginVertex(originVertex2);
        }

        setIndexesInVertices(vertices);

        return vertices;
    }

    private static void setIndexesInVertices(List<Vertex> vertices) {
        for (int i = 0; i < vertices.size(); i++) {
            Vertex vertex = vertices.get(i);
            vertex.setIndexInVerticesList(i);
        }
    }

    private static int getIndexOfNumber(int i, int numberOfVertices) {
        int index;
        if (i > 0) {
            index = i - 1 + numberOfVertices;
        } else {
            index = i * -1 - 1;
        }

        return index;
    }
}
