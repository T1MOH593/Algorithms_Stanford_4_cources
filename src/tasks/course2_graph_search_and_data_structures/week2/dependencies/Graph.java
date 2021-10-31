package tasks.course2_graph_search_and_data_structures.week2.dependencies;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Vertex> vertices = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();

    public Graph() {
    }

    public boolean addVertex(Vertex vertex) {
        return vertices.add(vertex);
    }

    public boolean addEdge(Edge edge) {
        return edges.add(edge);
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }
}
