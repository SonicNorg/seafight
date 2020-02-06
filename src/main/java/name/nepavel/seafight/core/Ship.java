package name.nepavel.seafight.core;

public class Ship {
    private final int size; //from 1 to 4
    private final Cell topLeft;

    public Ship(int size, Cell topLeft) {
        this.size = size;
        this.topLeft = topLeft;
    }

    public int getSize() {
        return size;
    }

    public Cell getTopLeft() {
        return topLeft;
    }
}
