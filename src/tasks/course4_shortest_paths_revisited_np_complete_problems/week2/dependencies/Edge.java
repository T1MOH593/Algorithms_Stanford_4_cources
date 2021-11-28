package tasks.course4_shortest_paths_revisited_np_complete_problems.week2.dependencies;

public class Edge {

    private Vertex left;
    private Vertex right;
    private double cost;

    public Edge(Vertex left, Vertex right, double cost) {
        this.left = left;
        this.right = right;
        this.cost = cost;
    }

    public Vertex getLeft() {
        return left;
    }

    public void setLeft(Vertex left) {
        this.left = left;
    }

    public Vertex getRight() {
        return right;
    }

    public void setRight(Vertex right) {
        this.right = right;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
