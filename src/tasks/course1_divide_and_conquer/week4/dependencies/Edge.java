package tasks.course1_divide_and_conquer.week4.dependencies;

import java.util.Objects;

public class Edge {

    private Vertex left;
    private Vertex right;

    public Edge(Vertex left, Vertex right) {
        this.left = left;
        this.right = right;
    }

    public Edge() {
    }

    public Vertex getLeft() {
        return left;
    }

    public void setLeft(Vertex left) {
        this.left = left;
    }

    public Vertex getRight() {
        return right;
    }

    public void setRight(Vertex right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return left.equals(edge.left) && right.equals(edge.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left.getValue() + right.getValue());
    }
}
