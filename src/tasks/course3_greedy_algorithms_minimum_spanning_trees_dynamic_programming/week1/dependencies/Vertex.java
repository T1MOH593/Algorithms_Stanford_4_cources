package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week1.dependencies;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private int number;
    private List<Edge> edges = new ArrayList<Edge>();
    private boolean isExplored;

    public Vertex(int number) {
        this.number = number;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public boolean isExplored() {
        return isExplored;
    }

    public void setExplored(boolean isExplored) {
        this.isExplored = isExplored;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public int getValue() {
        return number;
    }

    public void setValue(int number) {
        this.number = number;
    }
}
