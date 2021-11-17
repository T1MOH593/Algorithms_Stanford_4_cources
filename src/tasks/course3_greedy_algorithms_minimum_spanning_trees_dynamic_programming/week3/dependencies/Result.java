package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week3.dependencies;

public class Result {

    private int minLength;
    private int maxLength;

    public Result(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
}
