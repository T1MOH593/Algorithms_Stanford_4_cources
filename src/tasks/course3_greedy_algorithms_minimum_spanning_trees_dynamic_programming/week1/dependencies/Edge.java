package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week1.dependencies;

public class Edge {

    private Vertex left;
    private Vertex right;
    private int cost;

    public Edge(Vertex left, Vertex right, int cost) {
        this.left = left;
        this.right = right;
        this.cost = cost;
    }

    public Edge() {
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
