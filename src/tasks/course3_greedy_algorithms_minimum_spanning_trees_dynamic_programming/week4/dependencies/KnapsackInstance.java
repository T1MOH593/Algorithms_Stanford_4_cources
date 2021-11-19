package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week4.dependencies;

public class KnapsackInstance {

    private int weight;
    private int value;

    public KnapsackInstance(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
