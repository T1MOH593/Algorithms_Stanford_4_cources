package tasks.course3_greedy_algorithms_minimum_spanning_trees_dynamic_programming.week2.dependencies;

import java.util.Objects;

public class Vertex2 {

    private int number;
    private int rank;
    private int parent;
    private int index;

    public Vertex2(String bits) {
        number = Integer.parseUnsignedInt(bits, 2);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        this.parent = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex2 vertex2 = (Vertex2) o;
        return number == vertex2.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
