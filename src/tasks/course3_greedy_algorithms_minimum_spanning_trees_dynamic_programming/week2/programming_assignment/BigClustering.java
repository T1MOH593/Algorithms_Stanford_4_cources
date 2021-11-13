package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week2.programming_assignment;

import tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week2.dependencies.UnionFind2;
import tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week2.dependencies.Vertex2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Math.pow;

public class BigClustering {

    public static int countMaxClustering(String filename, int lengthOfVertex) throws IOException {
        Map<Integer, Vertex2> map = init(filename);
        int maxClustering = getMaxClustering(map, lengthOfVertex);
        return maxClustering;
    }

    private static Map<Integer, Vertex2> init(String filename) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(filename));
        strings.remove(0);
        Map<Integer, Vertex2> map = new HashMap<>(strings.size());
        int counter = 0;
        for (String string : strings) {
            Vertex2 vertex = new Vertex2(string.replaceAll(" ", ""));
            vertex.setIndex(counter++);
            map.put(vertex.getNumber(), vertex);
        }

        return map;
    }

    private static int getMaxClustering(Map<Integer, Vertex2> map, int lengthOfVertex) {
        List<Integer> bitMasks = getBitMasks(lengthOfVertex);
        UnionFind2 unionFind = new UnionFind2(map);

        int result = map.size();
        for (Integer integer : map.keySet()) {
            Vertex2 vertex1 = map.get(integer);
            for (Integer bitMask : bitMasks) {
                int numberOfSecondVertex = vertex1.getNumber() ^ bitMask;
                if (map.containsKey(numberOfSecondVertex)) {
                    Vertex2 vertex2 = map.get(numberOfSecondVertex);
                    if (unionFind.find(vertex2.getIndex()) != unionFind.find(vertex1.getIndex())) {
                        unionFind.union(vertex1, vertex2);
                        result--;
                    }
                }
            }
        }
        return result;
    }

    private static List<Integer> getBitMasks(int numberOfBits) {
        int length = 1 + numberOfBits + numberOfBits*(numberOfBits - 1)/2;
        List<Integer> bitMasks = new ArrayList<>(length);
        bitMasks.add(0);
        for (int i = 0; i < numberOfBits; i++) {
            bitMasks.add((int) pow(2, i));
        }
        for (int i = 0; i < numberOfBits; i++) {
            for (int j = i + 1; j < numberOfBits; j++) {
                bitMasks.add((int) (pow(2, i) + pow(2, j)));
            }
        }
        return bitMasks;
    }
}
