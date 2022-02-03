package tasks.course1_divide_and_conquer.week2.programming_assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static tasks.course1_divide_and_conquer.week2.programming_assignment.CountingTheInversions.sortAndCount;

public class Runner {

    public static void main(String[] args) throws IOException {
        List<String> list = Files.readAllLines(Paths.get("src", "resources", "Integer_Array.txt"));
        int[] nums = new int[100_000];
        int i = 0;
        for (String s : list) {
            nums[i++] = Integer.parseInt(s);
        }
        Result result = sortAndCount(nums);
        System.out.println(result.getInversions());
    }
}
