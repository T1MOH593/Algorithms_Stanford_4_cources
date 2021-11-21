package tasks.course4_shortest_paths_revisited_np_complete_problems.week1.dependencies;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Edge> edges = new ArrayList<>();
    private List<Vertex> vertices = new ArrayList<>();

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
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

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }
}
