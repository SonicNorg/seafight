package name.nepavel.seafight.core;

import java.util.HashSet;
import java.util.Set;

public class Ship {
    private final HashSet<Cell> cells;
    private final HashSet<Cell> damagedCells;

    public Ship(HashSet<Cell> cells) {
        this.cells = cells;
        this.damagedCells = new HashSet<>(cells.size());
    }

    public boolean isOn(Cell cell) {
        return cells.contains(cell);
    }

    public boolean isDead() {
        return cells.size() == damagedCells.size();
    }

    public boolean cellDamaged(Cell cell) {
        return damagedCells.contains(cell);
    }

    public boolean hit(Cell cell) {
        if (cells.contains(cell)) {
            damagedCells.add(cell);
            return true;
        }
        return false;
    }

    public Set<Cell> getCells() {
        return cells;
    }
}
