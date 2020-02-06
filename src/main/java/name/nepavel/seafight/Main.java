package name.nepavel.seafight;

import name.nepavel.seafight.core.*;
import name.nepavel.seafight.view.ConsoleView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        ConsoleView view = new ConsoleView(game);
        game.setPlayer1(new Player("Pavel"));
        game.setPlayer2(new Player("Sasha"));
//        System.out.println("Enter " + game.getPlayer1().getName() + " field:");
//        GameField field1 = game.getPlayer1().getField();
        System.out.println("Enter " + game.getPlayer2().getName() + " field:");
        GameField field2 = game.getPlayer2().getField();
        FieldReader.parse(readField()).forEach(field2::addShip);

//        field1.addShip(new Ship(
//                new HashSet<>(Arrays.asList(
//                        new Cell(2, 3),
//                        new Cell(2, 4),
//                        new Cell(2, 5)
//                ))
//        ));

//        field2.addShip(new Ship(
//                new HashSet<>(Arrays.asList(
//                        new Cell(4, 3),
//                        new Cell(5, 3),
//                        new Cell(6, 3)
//                ))
//        ));
        System.out.println(view.fieldView(field2));

        game.start();
        System.out.println("2, 3");
        game.move(2, 3);

        System.out.println(view.fieldView(field2));
    }

    private static List<String> readField() throws IOException {
        List<String> result = new ArrayList<>(10);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            result.add(reader.readLine());
        }
        return result;
    }
}
