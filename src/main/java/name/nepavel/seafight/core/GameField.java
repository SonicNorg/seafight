package name.nepavel.seafight.core;

import java.util.*;

public class GameField {
    private Cell[][] field;
    private Map<Cell,Ship> ships = new HashMap<>();

    public GameField() {
        field = new Cell[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j] = new Cell(i, j);
            }
        }
    }

    public void addShip(Ship ship) {
        ships.put(ship.getTopLeft(), ship);
    }

    public Map<Cell, Ship> getShips() {
        return ships;
    }

    public Cell[][] getField() {
        return field;
    }

    public HitResult attack(int x, int y) {
        return null;
    }

    @Override
    public String toString() {
        return "GameField{" +
                "field=" + Arrays.deepToString(field) +
                '}';
    }
}
