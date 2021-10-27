package tasks.course2_graph_search.week2.dependencies;

public class Vertex {

    private int value;
    private int dijkstraCoefficient;

    public Vertex(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getDijkstraCoefficient() {
        return dijkstraCoefficient;
    }

    public void setDijkstraCoefficient(int dijkstraCoefficient) {
        this.dijkstraCoefficient = dijkstraCoefficient;
    }
}
