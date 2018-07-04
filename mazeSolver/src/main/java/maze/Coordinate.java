package maze;

public class Coordinate {

    private int x;
    private int y;
    private Coordinate parent;

    public Coordinate(int x, int y, Coordinate parent){
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
        this.parent = null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinate getParent() {
        return parent;
    }

    public void setParent(Coordinate parent) {
        this.parent = parent;
    }
}
