package tasks.course4_shortest_paths_revisited_np_complete_problems.week4.dependencies;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private int number;
    private List<Vertex> destinationVertices = new ArrayList<>();
    private List<Vertex> originVertices = new ArrayList<>();
    private boolean isExplored;
    private int indexInVerticesList;
    private int numberOfParentVertex;

    public int getIndexInVerticesList() {
        return indexInVerticesList;
    }

    public void setIndexInVerticesList(int indexInVerticesList) {
        this.indexInVerticesList = indexInVerticesList;
    }

    public Vertex(int number) {
        this.number = number;
    }

    public void addDestinationVertex(Vertex vertex) {
        destinationVertices.add(vertex);
    }

    public int getNumberOfParentVertex() {
        return numberOfParentVertex;
    }

    public void setNumberOfParentVertex(int numberOfParentVertex) {
        this.numberOfParentVertex = numberOfParentVertex;
    }

    public boolean isExplored() {
        return isExplored;
    }

    public void setExplored(boolean explored) {
        isExplored = explored;
    }

    public int getNumber() {
        return number;
    }

    public void addOriginVertex(Vertex vertex) {
        originVertices.add(vertex);
    }

    public List<Vertex> getOriginVertices() {
        return originVertices;
    }

    public void setOriginVertices(List<Vertex> originVertices) {
        this.originVertices = originVertices;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Vertex> getDestinationVertices() {
        return destinationVertices;
    }

    public void setDestinationVertices(List<Vertex> destinationVertices) {
        this.destinationVertices = destinationVertices;
    }
}
