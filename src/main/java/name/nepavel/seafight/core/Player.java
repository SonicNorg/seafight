package name.nepavel.seafight.core;

public class Player {
    private String name;
    private GameField field = new GameField();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public GameField getField() {
        return field;
    }

    public void setField(GameField field) {
        this.field = field;
    }
}
