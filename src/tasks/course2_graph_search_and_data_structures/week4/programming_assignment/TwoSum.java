package tasks.course2_graph_search_and_data_structures.week4.programming_assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Long.parseLong;

public class TwoSum {

    public static int countDifferentSum10_000LongFromZero(String filename) throws IOException {
        long l = System.currentTimeMillis();
        Set<Long> set = init(filename);
        boolean[] sumArray = new boolean[20_001];
        int counter1 = 0;
        for (Long aLong : set) {
            for (int i = -10_000; i <= 10_000; i++) {
                long searchingNumber = i - aLong;
                if (set.contains(searchingNumber)) {
                    sumArray[i + 10_000] = true;
                }
            }
            System.out.println(++counter1 + "th operation of 1 million loop");
        }
        int counter = 0;
        for (int i = 0; i < sumArray.length; i++) {
            if (sumArray[i] == true) {
                counter++;
            }
        }
        System.out.println("time: " + (System.currentTimeMillis() - l));
        return counter;
    }

    public static Set<Long> init(String filename) throws IOException {
        Set<Long> set = new HashSet<>(1_250_000, .75f);

        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filename));
        while (bufferedReader.ready()) {
            long l = parseLong(bufferedReader.readLine());
            set.add(l);
        }
        return set;
    }
}
