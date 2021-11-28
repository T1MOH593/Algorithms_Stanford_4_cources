package tasks.course4_shortest_paths_revisited_np_complete_problems.week2.dependencies;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private int number;
    private double x;
    private double y;
    private List<Edge> edges = new ArrayList<>();

    public Vertex(int number, double x, double y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}
