package name.nepavel.seafight.core;

import java.util.*;

public class FieldReader {
    public static Set<Ship> parse(List<String> rows) {
        HashMap<Cell, Ship> shipsFound = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (rows.get(i).charAt(j) == 'x') {
                    Cell prevX = new Cell(i - 1, j);
                    Cell prevY = new Cell(i, j - 1);
                    Cell cell = new Cell(i, j);
                    if (shipsFound.containsKey(prevX)) {
                        shipsFound.get(prevX).getCells().add(cell);
                    } else if (shipsFound.containsKey(prevY)) {
                        shipsFound.get(prevY).getCells().add(cell);
                    } else {
                        shipsFound.put(cell, new Ship(new HashSet<>(Arrays.asList(cell))));
                    }
                }
            }
        }
        return new HashSet<>(shipsFound.values());
    }
}
