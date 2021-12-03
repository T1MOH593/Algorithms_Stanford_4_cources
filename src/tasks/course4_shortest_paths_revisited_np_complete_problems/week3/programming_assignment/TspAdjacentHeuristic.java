package tasks.course4_shortest_paths_revisited_np_complete_problems.week3.programming_assignment;

import tasks.course4_shortest_paths_revisited_np_complete_problems.week3.dependencies.Vertex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;

public class TspAdjacentHeuristic {

    public static void start(String filename) throws IOException {
        List<Vertex> vertices = init(filename);
        int counter = 0;
        int indexOfCurrentVertex = 0;
        double result = 0;
        vertices.get(0).setIncluded(true);
        while (counter <= vertices.size() - 1) {
            Vertex currentVertex = vertices.get(indexOfCurrentVertex);
            double min = Double.MAX_VALUE;
            int indexOfNextVertex = -1;
            Vertex nextVertex = null;
            for (int i = 0; i < vertices.size(); i++) {
                nextVertex = vertices.get(i);
                double cost = sqrt(pow(currentVertex.getX() - nextVertex.getX(), 2) + pow(currentVertex.getY() - nextVertex.getY(), 2));
                if (cost != 0 && min > cost && !nextVertex.isIncluded()) {
                    min = cost;
                    indexOfNextVertex = i;
                }
            }
            try {
                vertices.get(indexOfNextVertex).setIncluded(true);
                result += min;
                indexOfCurrentVertex = indexOfNextVertex;
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
            counter++;
            System.out.println(counter);
        }
        result += sqrt(pow(vertices.get(indexOfCurrentVertex).getX() - vertices.get(0).getX(), 2) + pow(vertices.get(indexOfCurrentVertex).getY() - vertices.get(0).getY(), 2));
        System.out.println(result);
    }

    private static List<Vertex> init(String filename) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(filename));
        List<Vertex> vertices = new ArrayList<>();
        for (int i = 1; i < strings.size(); i++) {
            String[] split = strings.get(i).split(" ");
            Vertex vertex = new Vertex(parseDouble(split[1]), parseDouble(split[2]));
            vertices.add(vertex);
        }
        return vertices;
    }
}
