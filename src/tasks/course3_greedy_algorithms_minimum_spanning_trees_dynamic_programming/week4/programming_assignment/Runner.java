package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week4.programming_assignment;

import tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week4.dependencies.KnapsackInstance;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
//        int result = Knapsack1.optimalValue("knapsack1.txt");
//        System.out.println(result);

        long result = KnapsackBig.optimalValue("knapsack_big.txt");
        System.out.println(result);
    }
}
