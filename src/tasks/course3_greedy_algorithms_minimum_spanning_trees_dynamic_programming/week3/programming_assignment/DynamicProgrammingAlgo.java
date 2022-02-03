package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week3.programming_assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.Integer.parseInt;

public class DynamicProgrammingAlgo {

    private static long[] globalArray;
    private static boolean[] globalResultArray;

    public static void showAnswer() {
        if (globalResultArray[0]) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
        if (globalResultArray[1]) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
        if (globalResultArray[2]) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
        if (globalResultArray[3]) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
        if (globalResultArray[16]) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
        if (globalResultArray[116]) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
        if (globalResultArray[516]) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
        if (globalResultArray[996]) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
    }

    public static long getResult(String filename) throws IOException {
        int[] ints = init(filename);
        long i = maxWeightedSum(ints, ints.length - 1);
        reconstruct(ints);
        showAnswer();
        return i;
    }

    public static void reconstruct(int[] ints) {
        int i = globalArray.length - 1;
        while (i >= 2) {
            long first = globalArray[i - 1];
            long second = globalArray[i - 2] + ints[i];
            if (first > second) {
                i--;
            } else {
                globalResultArray[i] = true;
                i -= 2;
            }
        }
        if (i == 1) {
            if (globalArray[i] > globalArray[i - 1]) {
                globalResultArray[i] = true;
            } else {
                globalResultArray[i - 1] = true;
            }
        } else {
            globalResultArray[0] = true;
        }
    }

    public static int[] init(String filename) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("src", "resources", filename));
        int length = parseInt(strings.get(0));
        strings.remove(0);
        int[] ints = new int[length];
        globalArray = new long[length];
        globalResultArray = new boolean[length];
        for (int i = 0; i < length; i++) {
            ints[i] = parseInt(strings.get(i));
        }
        return ints;
    }

    public static long maxWeightedSum(int[] ints, int index) {
        if (globalArray[index] != 0) {
            return globalArray[index];
        }
        if (index == 1) {
            globalArray[1] = Math.max(ints[0], ints[1]);
            return Math.max(ints[0], ints[1]);
        } else if (index == 0) {
            globalArray[0] = ints[0];
            return ints[0];
        }

        long first = maxWeightedSum(ints, index - 1);
        long second = maxWeightedSum(ints, index - 2) + ints[index];
        long max = Math.max(first, second);
        globalArray[index] = max;
        return max;
    }
}
