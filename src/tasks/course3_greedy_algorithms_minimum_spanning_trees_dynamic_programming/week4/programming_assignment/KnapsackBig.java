package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week4.programming_assignment;

import tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week4.dependencies.KnapsackInstance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.Integer.parseInt;

public class KnapsackBig {

    static private int[][] matrix;

    public static int optimalValue(String filename) throws IOException {
        KnapsackInstance[] knapsackInstanceArray = init(filename);
        return optimalValue(knapsackInstanceArray);
    }

    private static KnapsackInstance[] init(String filename) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("src", "resources", filename));
        String[] split = strings.get(0).split(" ");
        strings.remove(0);
        matrix = new int[2][parseInt(split[0]) + 1];
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
        int counter = 0;
        for (int i = 1; i < knapsackInstanceArray.length + 1; i++) {
            for (int j = 0; j < matrix[i - counter].length; j++) {
                int first = matrix[i - 1 - counter][j];
                int second;
                if (j - knapsackInstanceArray[i - 1].getWeight() >= 0) {
                    second = matrix[i - 1 - counter][j - knapsackInstanceArray[i - 1].getWeight()] + knapsackInstanceArray[i - 1].getValue();
                } else {
                    second = 0;
                }
                matrix[i - counter][j] = Math.max(first, second);
            }
            counter++;
            for (int l = 0; l < matrix[0].length; l++) {
                matrix[0][l] = matrix[1][l];
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }
}
