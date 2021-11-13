package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week2.dependencies;

public class Edge {

    private int left;
    private int right;
    private int cost;

    public Edge(int left, int right, int cost) {
        this.left = left;
        this.right = right;
        this.cost = cost;
    }

    public Edge() {
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
