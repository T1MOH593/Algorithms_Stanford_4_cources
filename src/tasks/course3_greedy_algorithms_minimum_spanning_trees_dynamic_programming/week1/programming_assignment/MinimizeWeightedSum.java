package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week1.programming_assignment;

import tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week1.dependencies.Job;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MinimizeWeightedSum {

    public static long count(String filename) throws IOException {
        List<String> list = Files.readAllLines(Paths.get("src", "resources", filename));
        List<Job> jobs = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            String[] split = list.get(i).split(" ");
            Job job = new Job(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            jobs.add(job);
        }
        jobs.sort((j1, j2) -> {
            if (j1.getWeight() * 1.0 / j1.getLength() > j2.getWeight() * 1.0 / j2.getLength()) {
                return -1;
            } else {
                return 1;
            }
        });

        long result = 0;
        long currentTime = 0;
        for (Job job : jobs) {
            currentTime += job.getLength();
            result += currentTime * job.getWeight();
        }
        return result;
    }
}
