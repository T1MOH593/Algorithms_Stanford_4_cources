package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week3.programming_assignment;

import tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week3.dependencies.Node;
import tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week3.dependencies.Result;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Integer.parseInt;

public class HuffmanAlgorithm {

    public static Result getMaxAndMinLength(String filename) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(filename));
        Node[] nodeArray = new Node[parseInt(strings.get(0))];
        strings.remove(0);
        for (int i = 0; i < strings.size(); i++) {
            nodeArray[i] = new Node(parseInt(strings.get(i)));
        }
        Arrays.sort(nodeArray, Comparator.comparingInt(Node::getValue));

        Queue<Node> queue1 = new ArrayDeque<>(nodeArray.length);
        queue1.addAll(Arrays.asList(nodeArray));

        Queue<Node> queue2 = new ArrayDeque<>();

        while (queue1.size() + queue2.size() > 1) {
            Node minNode1 = getMinNode(queue1, queue2);
            Node minNode2 = getMinNode(queue1, queue2);
            Node merge = minNode1.merge(minNode2);
            queue2.add(merge);
        }
        Arrays.sort(nodeArray, Comparator.comparingInt(Node::getLength));
        Result result = new Result(nodeArray[0].getLength(), nodeArray[nodeArray.length - 1].getLength());
        return result;
    }

    private static Node getMinNode(Queue<Node> queue1, Queue<Node> queue2) {
        Node node;
        Node temp1 = queue1.peek();
        Node temp2 = queue2.peek();
        if (temp1 != null && temp2 != null) {
            if (temp1.getValue() < temp2.getValue()) {
                node = temp1;
                queue1.remove();
            } else {
                node = temp2;
                queue2.remove();
            }
        } else if (temp1 == null) {
            node = temp2;
            queue2.remove();
        } else {
            node = temp1;
            queue1.remove();
        }
        return node;
    }
}
