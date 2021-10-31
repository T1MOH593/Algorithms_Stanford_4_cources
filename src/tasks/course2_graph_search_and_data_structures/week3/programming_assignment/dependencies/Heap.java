package tasks.course2_graph_search_and_data_structures.week3.programming_assignment.dependencies;

import java.util.Arrays;

public interface Heap<T extends Comparable> {

    void insert(T object);
    int size();

    @SafeVarargs
    static <T> T[] newArray(int length, T... array)
    {
        return Arrays.copyOf(array, length);
    }
}
