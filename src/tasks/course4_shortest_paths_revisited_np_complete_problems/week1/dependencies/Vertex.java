package tasks.course4_shortest_paths_revisited_np_complete_problems.week1.dependencies;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private List<Edge> outgoingEdges = new ArrayList<>();
    private List<Edge> ingoingEdges = new ArrayList<>();
    private int weight;
    private int number;
    private int dijkstraCoefficient;

    public void addOutgoingEdge(Edge edge) {
        outgoingEdges.add(edge);
    }

    public int getDijkstraCoefficient() {
        return dijkstraCoefficient;
    }

    public void setDijkstraCoefficient(int dijkstraCoefficient) {
        this.dijkstraCoefficient = dijkstraCoefficient;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void addIngoingEdge(Edge edge) {
        ingoingEdges.add(edge);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Edge> getOutgoingEdges() {
        return outgoingEdges;
    }

    public void setOutgoingEdges(List<Edge> outgoingEdges) {
        this.outgoingEdges = outgoingEdges;
    }

    public List<Edge> getIngoingEdges() {
        return ingoingEdges;
    }

    public void setIngoingEdges(List<Edge> ingoingEdges) {
        this.ingoingEdges = ingoingEdges;
    }
}
