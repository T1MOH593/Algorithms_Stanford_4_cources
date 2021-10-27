package tasks.course2_graph_search.week2.programming_assignment;

import java.io.IOException;

import static tasks.course2_graph_search.week2.programming_assignment.DijkstraShortestPath.*;

public class Runner {

    public static void main(String[] args) throws IOException {
        countShortestPaths("dijkstraData.txt", 1);
    }
}
