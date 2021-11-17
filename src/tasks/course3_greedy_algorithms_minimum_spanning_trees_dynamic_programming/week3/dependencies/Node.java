package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week3.dependencies;

public class Node {

    private Node parent;
    private int value;
    private String letter;
    private Node leftChild;
    private Node rightChild;
    private int length;

    public Node(Integer value) {
        this.value = value;
    }

    public Node merge(Node node2) {
        Node newNode = new Node(this.value + node2.value);
        newNode.setLeftChild(this);
        newNode.setRightChild(node2);
        incrementLength(newNode);
        this.parent = newNode;
        node2.parent = newNode;
        return newNode;
    }

    private void incrementLength(Node newNode) {
        if (newNode.getLeftChild() != null) {
            Node leftChild = newNode.getLeftChild();
            leftChild.setLength(leftChild.getLength() + 1);
            incrementLength(leftChild);
        }
        if (newNode.getRightChild() != null) {
            Node rightChild = newNode.getRightChild();
            rightChild.setLength(rightChild.getLength() + 1);
            incrementLength(rightChild);
        }
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
