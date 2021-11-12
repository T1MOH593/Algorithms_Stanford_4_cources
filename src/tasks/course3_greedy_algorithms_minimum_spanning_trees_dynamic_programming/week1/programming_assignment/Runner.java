package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week1.programming_assignment;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        System.out.println(MinimizeWeightedSum.count("jobs.txt"));
        System.out.println(MinimumSpanningTree.costOfMST("edges.txt"));
    }
}
