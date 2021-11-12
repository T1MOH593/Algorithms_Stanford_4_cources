package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week1.dependencies;

public class Job {
    private int weight;
    private int length;

    public Job(int weight, int length) {
        this.weight = weight;
        this.length = length;
    }

    public int getWeight() {
        return weight;
    }

    public int getLength() {
        return length;
    }
}
