package tasks.course1_divide_and_conquer.week2.programming_assignment;

import java.util.Arrays;

public class Result {
    private long inversions;
    private int[] array;

    public Result(long inversions, int[] array) {
        this.inversions = inversions;
        this.array = array;
    }

    public long getInversions() {
        return inversions;
    }

    public int[] getArray() {
        return array;
    }

    @Override
    public String toString() {
        return "Result{" +
                "inversions=" + inversions +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
