package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week3.programming_assignment;

import tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week3.dependencies.Result;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
//        Result result = HuffmanAlgorithm.getMaxAndMinLength("huffman.txt");
//        System.out.println("min: " + result.getMinLength());
//        System.out.println("max: " + result.getMaxLength());
        long result = DynamicProgrammingAlgo.getResult("mwis.txt");
    }
}
