package name.nepavel.seafight.view;

import name.nepavel.seafight.core.CellWithShip;
import name.nepavel.seafight.core.Game;
import name.nepavel.seafight.core.GameField;

public class ConsoleView {
    private Game game;

    public ConsoleView(Game game) {
        this.game = game;
    }

    public char cellView(CellWithShip cell) {
        if (cell.getShip() == null) {
            if (cell.isShot()) {
                return '\u25fe';
            } else {
                return '\u25e6';
            }
        } else {
            return cell.getShip() ? '\u25a3' : '\u25a1';
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
