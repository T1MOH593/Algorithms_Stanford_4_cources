package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week2.programming_assignment;

import tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week2.dependencies.Vertex2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Runner {

    public static void main(String[] args) throws IOException {
        System.out.println(Clustering1.maxSpacingKClustering("clustering1.txt", 4));
        int init = BigClustering.countMaxClustering("clustering_big.txt", 24);
        System.out.println(init);
    }
}
