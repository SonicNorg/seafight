package name.nepavel.seafight.core;

import java.util.LinkedList;

public class Player {
    private String name;
    private GameField field = new GameField();
    private LinkedList<Cell> moves = new LinkedList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public GameField getField() {
        return field;
    }
}
