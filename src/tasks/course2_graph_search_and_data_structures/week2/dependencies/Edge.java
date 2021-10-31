package tasks.course2_graph_search_and_data_structures.week2.dependencies;

public class Edge {

    private Vertex leftVertex;
    private Vertex rightVertex;
    private int value;

    public Edge(Vertex leftVertex, Vertex rightVertex, int value) {
        this.leftVertex = leftVertex;
        this.rightVertex = rightVertex;
        this.value = value;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
