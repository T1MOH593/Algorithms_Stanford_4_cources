package tasks.course2_graph_search.week1.dependencies;

import java.util.List;

public class Edge {

    private Vertex leftVertex;
    private Vertex rightVertex;

    public Edge(Vertex leftVertex, Vertex rightVertex) {
        this.leftVertex = leftVertex;
        this.rightVertex = rightVertex;
    }

    public Edge() {
    }

    public Vertex getLeftVertex() {
        return leftVertex;
    }

    public void setLeftVertex(Vertex leftVertex) {
        this.leftVertex = leftVertex;
    }

    public Vertex getRightVertex() {
        return rightVertex;
    }

    public void setRightVertex(Vertex rightVertex) {
        this.rightVertex = rightVertex;
    }
}
