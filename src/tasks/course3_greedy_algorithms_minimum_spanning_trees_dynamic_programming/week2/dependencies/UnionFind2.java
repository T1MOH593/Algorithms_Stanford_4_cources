package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week2.dependencies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnionFind2 {

    private Vertex2[] array;

    public UnionFind2(Map<Integer, Vertex2> map) {
        array = new Vertex2[map.keySet().size()];
        int i = 0;
        for (Integer integer : map.keySet()) {
            Vertex2 vertex = map.get(integer);
            array[i] = vertex;
            vertex.setIndex(i++);
        }
    }

    public Vertex2 find(int indexOfVertex) {
        Vertex2 vertex = array[indexOfVertex];
        List<Integer> changingVertices = new ArrayList<>();
        while(array[vertex.getIndex()] != array[vertex.getParent()]) {
            changingVertices.add(vertex.getIndex());
            vertex = array[vertex.getParent()];
        }
        for (Integer i : changingVertices) {
            Vertex2 v = array[i];
            v.setParent(vertex.getIndex());
        }
        return vertex;
    }

    public void union(Vertex2 vertex1, Vertex2 vertex2) {
        vertex1 = find(vertex1.getIndex());
        vertex2 = find(vertex2.getIndex());
        if (vertex1.getRank() > vertex2.getRank()) {
            vertex2.setParent(vertex1.getIndex());
        } else if (vertex1.getRank() < vertex2.getRank()) {
            vertex1.setParent(vertex2.getIndex());
        } else {
            vertex2.setParent(vertex1.getIndex());
            vertex1.setRank(vertex1.getRank() + 1);
        }
    }
}
