package name.nepavel.seafight.view;

import name.nepavel.seafight.core.Cell;
import name.nepavel.seafight.core.CellWithShip;
import name.nepavel.seafight.core.Game;
import name.nepavel.seafight.core.GameField;

public class ConsoleView {
    private Game game;

    public ConsoleView(Game game) {
        this.game = game;
    }

    public char cellView(CellWithShip cell, boolean masked) {
        if (cell.getShip() == null) {
            return emptyCellView(cell);
        } else {
            return cell.getShip() ? '\u25a3' : masked ? emptyCellView(cell) : '\u25a1';
        }
    }

    public char emptyCellView(Cell emptyCell) {
        if (emptyCell.isShot()) {
            return '\u25fe';
        } else {
            return '\u25e6';
        }
    }

    public String fieldView(GameField field, boolean masked) {
        StringBuilder fieldView = new StringBuilder();
        for(int i = 0; i < field.getField().length; i++) {
            for(int j = 0; j < field.getField().length; j++) {
                fieldView.append(cellView(field.getField()[i][j], masked));
                fieldView.append(" ");
            }
            fieldView.append('\n');
        }
        return fieldView.toString();
    }
}
