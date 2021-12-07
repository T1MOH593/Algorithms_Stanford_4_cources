package tasks.course4_shortest_paths_revisited_np_complete_problems.week4.programming_assignment;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        boolean b1 = TwoSatAlgorithm.twoSatAlgorithm("2sat1.txt");
        if (b1) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
        boolean b2 = TwoSatAlgorithm.twoSatAlgorithm("2sat2.txt");
        if (b2) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
        boolean b3 = TwoSatAlgorithm.twoSatAlgorithm("2sat3.txt");
        if (b3) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
        boolean b4 = TwoSatAlgorithm.twoSatAlgorithm("2sat4.txt");
        if (b4) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
        boolean b5 = TwoSatAlgorithm.twoSatAlgorithm("2sat5.txt");
        if (b5) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
        boolean b6 = TwoSatAlgorithm.twoSatAlgorithm("2sat6.txt");
        if (b6) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
    }
}
