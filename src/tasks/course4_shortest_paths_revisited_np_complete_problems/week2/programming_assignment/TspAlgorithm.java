package tasks.course4_shortest_paths_revisited_np_complete_problems.week2.programming_assignment;

import tasks.course4_shortest_paths_revisited_np_complete_problems.week2.dependencies.Edge;
import tasks.course4_shortest_paths_revisited_np_complete_problems.week2.dependencies.Graph;
import tasks.course4_shortest_paths_revisited_np_complete_problems.week2.dependencies.Vertex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Math.*;

public class TspAlgorithm {

    public static void algorithm(String filename) throws IOException {
        float[][] vertexCosts = init(filename);
        int n = vertexCosts.length - 1;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        float[][] array = new float[(int) pow(2, n - 1)][n];
        fillWithBitMasks(map, n);
        array[0][0] = 0f;
        for (int i = 1; i < array.length; i++) {
            array[i][0] = Float.MAX_VALUE;
        }
        for (int m = 2; m <= n; m++) {
            System.out.println(m);
            Map<Integer, Integer> loopMap = map.get(m);
            for (Integer integer : loopMap.keySet()) {
                int temp = integer;
                int key = loopMap.get(integer);
                int[] ints = new int[m];
                int counter = 0;
                int index = 0;
                while (temp != 0) {
                    counter++;
                    if ((temp & 1) == 1) {

                        ints[index++] = counter;
                    }
                    temp >>= 1;
                }
                List<Float> localResults = new ArrayList<>();
                for (int j : ints) {
                    if (j == 1) {
                        continue;
                    }
                    float min = Float.MAX_VALUE;
                    for (int k : ints) {
                        if (k == j || k == 1) {
                            continue;
                        }
                        int indexOfSetWithoutJ = integer - (1 << (j - 1));
                        if (map.get(m - 1).get(indexOfSetWithoutJ) != null) {
                            float value = array[map.get(m - 1).get(indexOfSetWithoutJ)][k - 1] + vertexCosts[k][j];
                            if (min > value) {
                                min = value;
                            }
                        }
                    }
                    if (min == Float.MAX_VALUE) {
                        min = vertexCosts[1][j];
                    }
                    array[loopMap.get(integer)][j - 1] = min;
                }
            }
        }
        float min = Float.MAX_VALUE;
        for (int j = 2; j <= n; j++) {
            float value = array[array.length - 1][j - 1] + vertexCosts[j][1];
            if (min > value) {
                min = value;
            }
        }
        System.out.println(min);
    }

    private static float[][] init(String filename) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(filename));
        Graph graph = new Graph();
        int n = Integer.parseInt(strings.get(0));
        float[][] vertexCosts = new float[n + 1][n + 1];
        for (int i = 1; i < strings.size(); i++) {
            String[] s = strings.get(i).split(" ");
            Vertex vertex = new Vertex(i, Double.parseDouble(s[0]), Double.parseDouble(s[1]));
            graph.addVertex(vertex);
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i != j) {
                    Vertex vertex1 = graph.getVertex(i - 1);
                    Vertex vertex2 = graph.getVertex(j - 1);
                    double cost = sqrt(pow(vertex1.getX() - vertex2.getX(), 2) + pow(vertex1.getY() - vertex2.getY(), 2));
                    vertexCosts[i][j] = (float) cost;
                }
            }
        }
        return vertexCosts;
    }

    private static void fillWithBitMasks(Map<Integer, Map<Integer, Integer>> map, int n) {
        int c = 0;
        for (int i = 1; i < 1 << n; i++) {
            int m = i;
            int counter = 0;
            while (m != 0) {
                m &= m - 1;
                counter++;
            }
            if (!map.containsKey(counter)) {
                Map<Integer, Integer> newMap = new HashMap<>();
                map.put(counter, newMap);
            }
            if ((i & 1) == 1) {
                map.get(counter).put(i, c++);
            }
        }
    }

}
