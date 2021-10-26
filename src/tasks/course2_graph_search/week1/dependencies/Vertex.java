package tasks.course2_graph_search.week1.dependencies;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private int value;
    private boolean isExplored;
    private List<Edge> outgoingEdges = new ArrayList<>();
    private List<Edge> reversedEdges = new ArrayList<>();

    public Vertex() {
    }

    public Vertex(int value) {
        this.value = value;
    }

    public boolean addOutgoingEdge(Edge edge) {
        return outgoingEdges.add(edge);
    }

    public boolean addIngoingEdge(Edge edge) {
        return reversedEdges.add(edge);
    }

    public boolean isExplored() {
        return isExplored;
    }

    public void setExplored(boolean explored) {
        isExplored = explored;
    }

    public int getValue() {
        return value;
    }

    public List<Edge> getReversedEdges() {
        return reversedEdges;
    }

    public void setReversedEdges(List<Edge> reversedEdges) {
        this.reversedEdges = reversedEdges;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Edge> getOutgoingEdges() {
        return outgoingEdges;
    }

    public void setOutgoingEdges(List<Edge> outgoingEdges) {
        this.outgoingEdges = outgoingEdges;
    }
}
