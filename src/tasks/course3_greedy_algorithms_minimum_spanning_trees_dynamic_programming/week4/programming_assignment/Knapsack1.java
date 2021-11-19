package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week4.programming_assignment;

import tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week4.dependencies.KnapsackInstance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Knapsack1 {

    static private int[][] matrix;

    public static int optimalValue(String filename) throws IOException {
        KnapsackInstance[] knapsackInstances = init(filename);
        return optimalValue(knapsackInstances);
    }

    private static KnapsackInstance[] init(String filename) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(filename));
        String[] split = strings.get(0).split(" ");
        strings.remove(0);
        matrix = new int[parseInt(split[1]) + 1][parseInt(split[0]) + 1];
        KnapsackInstance[] knapsackInstanceArray = new KnapsackInstance[parseInt(split[1])];
        for (int i = 0; i < strings.size(); i++) {
            String[] s = strings.get(i).split(" ");
            int value = parseInt(s[0]);
            int weight = parseInt(s[1]);
            knapsackInstanceArray[i] = new KnapsackInstance(weight, value);
        }
        return knapsackInstanceArray;
    }

    private static int optimalValue(KnapsackInstance[] knapsackInstanceArray) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int first = matrix[i - 1][j];
                int second;
                if (j - knapsackInstanceArray[i - 1].getWeight() >= 0) {
                    second = matrix[i - 1][j - knapsackInstanceArray[i - 1].getWeight()] + knapsackInstanceArray[i - 1].getValue();
                } else {
                    second = 0;
                }
                matrix[i][j] = Math.max(first, second);
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }
}
