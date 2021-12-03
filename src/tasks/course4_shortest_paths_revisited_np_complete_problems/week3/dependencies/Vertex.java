package tasks.course4_shortest_paths_revisited_np_complete_problems.week3.dependencies;


public class Vertex {

    private double x;
    private double y;
    private boolean isIncluded;

    public Vertex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean isIncluded() {
        return isIncluded;
    }

    public void setIncluded(boolean included) {
        isIncluded = included;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}