package name.nepavel.seafight.view;

import name.nepavel.seafight.core.Cell;
import name.nepavel.seafight.core.Game;
import name.nepavel.seafight.core.GameField;

public class ConsoleView {
    private Game game;

    public ConsoleView(Game game) {
        this.game = game;
    }

    public char cellView(Cell emptyCell) {
        if (emptyCell.isShot()) {
            return '\u2022';
        } else {
            return '~';
        }
    }

    public String fieldView(GameField field) {
        StringBuilder fieldView = new StringBuilder();
        for(int i = 0; i < field.getField().length; i++) {
            for(int j = 0; j < field.getField().length; j++) {
                fieldView.append(cellView(field.getField()[i][j]));
                fieldView.append(" ");
            }
            fieldView.append('\n');
        }
        return fieldView.toString();
    }
}
