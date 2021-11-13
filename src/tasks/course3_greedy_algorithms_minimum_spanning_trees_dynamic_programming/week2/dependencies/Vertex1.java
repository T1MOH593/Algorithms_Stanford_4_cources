package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week2.dependencies;

public class Vertex1 {

    private int number;
    private int rank;
    private int parent;

    public Vertex1(int number) {
        this.number = number;
        this.parent = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }
}
