package tasks.course2_graph_search_and_data_structures.week3.programming_assignment;

import tasks.course2_graph_search_and_data_structures.week3.programming_assignment.dependencies.MaxHeap;
import tasks.course2_graph_search_and_data_structures.week3.programming_assignment.dependencies.MinHeap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MedianValue {

    static MaxHeap<Integer> lowestHalf = new MaxHeap<>();
    static MinHeap<Integer> biggestHalf = new MinHeap<>();

    public static int getSumOfMedians(String filename) throws IOException {
        List<String> list = Files.readAllLines(Paths.get(filename));
        int sumOfMedians = 0;
        for (String s : list) {
            sumOfMedians += addValue(Integer.parseInt(s));
        }
       return sumOfMedians % 10_000;
    }

    public static int addValue(Integer integer) {
        if (lowestHalf.size() == 0) {
            lowestHalf.insert(integer);
        } else if (integer < lowestHalf.max()) {
            lowestHalf.insert(integer);
        } else if (biggestHalf.min() == null ||
                    integer > biggestHalf.min()) {
            biggestHalf.insert(integer);
        } else {
            lowestHalf.insert(integer);
        }
        checkMedian();
        return lowestHalf.max();
    }

    private static void checkMedian() {
        while (biggestHalf.size() > lowestHalf.size()) {
            lowestHalf.insert(biggestHalf.extractMin());
        }
        while (lowestHalf.size() > biggestHalf.size() + 1) {
            biggestHalf.insert(lowestHalf.extractMax());
        }
    }
}
