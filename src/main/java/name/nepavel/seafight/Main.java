package name.nepavel.seafight;

import name.nepavel.seafight.core.*;
import name.nepavel.seafight.view.ConsoleView;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        ConsoleView view = new ConsoleView(game);
        game.setPlayer1(new Player("Pavel"));
        game.setPlayer2(new Player("Sasha"));
        GameField field1 = game.getPlayer1().getField();
        GameField field2 = game.getPlayer2().getField();

        field1.addShip(new Ship(
                new HashSet<>(Arrays.asList(
                        new Cell(2, 3),
                        new Cell(2, 4),
                        new Cell(2, 5)
                ))
        ));

        field2.addShip(new Ship(
                new HashSet<>(Arrays.asList(
                        new Cell(4, 3),
                        new Cell(5, 3),
                        new Cell(6, 3)
                ))
        ));
        System.out.println(view.fieldView(field1));

        game.start();
        game.move(2, 3);
        System.out.println("2, 4");
        game.move(2, 4);

        System.out.println(view.fieldView(field1));
    }
}
