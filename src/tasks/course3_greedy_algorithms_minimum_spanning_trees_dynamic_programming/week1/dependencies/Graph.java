package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week1.dependencies;

import java.util.List;

public class Graph {

    private List<Vertex> vertexList;

    public Graph(List<Vertex> vertexList) {
        this.vertexList = vertexList;
    }

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    public void setVertexList(List<Vertex> vertexList) {
        this.vertexList = vertexList;
    }
}
