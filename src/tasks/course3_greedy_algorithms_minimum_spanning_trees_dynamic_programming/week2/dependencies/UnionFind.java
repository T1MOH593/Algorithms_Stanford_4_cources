package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week2.dependencies;

import java.util.ArrayList;
import java.util.List;

public class UnionFind {

    private Vertex1[] array;

    public UnionFind(int lengthOfArray) {
        array = new Vertex1[lengthOfArray + 1];
        for (int i = 1; i < lengthOfArray + 1; i++) {
            array[i] = new Vertex1(i);
        }
    }

    public Vertex1 find(int numberOfVertex) {
        Vertex1 vertex = array[numberOfVertex];
        List<Integer> changingVertices = new ArrayList<>();
        while(array[vertex.getNumber()] != array[vertex.getParent()]) {
            changingVertices.add(vertex.getNumber());
            vertex = array[vertex.getParent()];
        }
        for (Integer i : changingVertices) {
            Vertex1 v = array[i];
            v.setParent(vertex.getNumber());
        }
        return vertex;
    }

    public void union(Vertex1 vertex1, Vertex1 vertex2) {
        vertex1 = find(vertex1.getNumber());
        vertex2 = find(vertex2.getNumber());
        if (vertex1.getRank() > vertex2.getRank()) {
            vertex2.setParent(vertex1.getNumber());
        } else if (vertex1.getRank() < vertex2.getRank()) {
            vertex1.setParent(vertex2.getNumber());
        } else {
            vertex2.setParent(vertex1.getNumber());
            vertex1.setRank(vertex1.getRank() + 1);
        }
    }
}
