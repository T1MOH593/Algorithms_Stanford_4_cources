package tasks.course2_graph_search_and_data_structures.week3.programming_assignment;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        int sumOfMedians = MedianValue.getSumOfMedians("Median.txt");
        System.out.println(sumOfMedians);
    }
}
