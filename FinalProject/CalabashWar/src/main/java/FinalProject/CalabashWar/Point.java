package FinalProject.CalabashWar;

public class Point {
    private int x;
    private int y;

    public void Point() {
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;
        if (this.x == p.x && this.y == p.y) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 20;
        result = result * 31 + Integer.valueOf(x).hashCode();
        result = result * 31 + Integer.valueOf(y).hashCode();
        return result;
    }
}
