package name.nepavel.seafight.core;

public class CellWithShip extends Cell {
    /**
     * Null means no ship, false means alive ship, true means dead ship
     */
    private final Boolean ship;

    public CellWithShip(Cell cell) {
        super(cell.getX(), cell.getY());
        setShot(cell.isShot());
        ship = null;
    }

    public CellWithShip(Cell cell, Boolean ship) {
        super(cell.getX(), cell.getY());
        setShot(cell.isShot());
        this.ship = ship;
    }

    public Boolean getShip() {
        return ship;
    }
}
