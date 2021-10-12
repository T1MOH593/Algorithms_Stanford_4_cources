package tasks.course1_divide_and_conquer.week3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static tasks.course1_divide_and_conquer.week3.QuickSort.sort;

public class Runner {

    public static void main(String[] args) throws IOException {
        List<String> list = Files.readAllLines(Paths.get("QuickSort.txt"));
        int[] nums = new int[100_000];
        int i = 0;
        for (String s : list) {
            nums[i++] = Integer.parseInt(s);
        }
        int result = sort(nums, 0, list.size() - 1);
        System.out.println(result);
    }
}
