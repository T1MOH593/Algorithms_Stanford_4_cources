package tasks.course4_shortest_paths_revisited_np_complete_problems.week1.dependencies;

public class Edge {

    private Vertex tail;
    private Vertex head;
    private int cost;

    public Edge(Vertex tail, Vertex head, int cost) {
        this.tail = tail;
        this.head = head;
        this.cost = cost;
    }

    public Vertex getTail() {
        return tail;
    }

    public void setTail(Vertex tail) {
        this.tail = tail;
    }

    public Vertex getHead() {
        return head;
    }

    public void setHead(Vertex head) {
        this.head = head;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
