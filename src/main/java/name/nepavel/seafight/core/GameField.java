package name.nepavel.seafight.core;

import java.util.*;

public class GameField {
    private Cell[][] field;
    private List<Ship> ships = new ArrayList<>();

    public GameField() {
        field = new Cell[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j] = new Cell(i, j);
            }
        }
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public CellWithShip[][] getField() {
        CellWithShip[][] result = new CellWithShip[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                result[i][j] = new CellWithShip(field[i][j]);
            }
        }
        for (Ship ship : ships) {
            for (Cell cell : ship.getCells()) {
                result[cell.getX()][cell.getY()] = new CellWithShip(cell, ship.cellDamaged(cell));
            }
        }
        return result;
    }

    public HitResult attack(Cell cell) {
        for (Ship ship : ships) {
            if (ship.isOn(cell)) {
                ship.hit(cell);
                return ship.isDead() ? HitResult.KILLED : HitResult.DAMAGED;
            }
        }
        field[cell.getX()][cell.getY()].setShot(true);
        return HitResult.MISS;
    }

    @Override
    public String toString() {
        return "GameField{" +
                "field=" + Arrays.deepToString(field) +
                '}';
    }

    public boolean allDead() {
        for (Ship ship : ships) {
            if (!ship.isDead()) {
                return false;
            }
        }
        return true;
    }
}
