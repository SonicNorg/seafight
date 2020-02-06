package name.nepavel.seafight;

import javafx.util.Pair;
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
        System.out.println("Enter " + game.getPlayer1().getName() + " field:");
        GameField field1 = game.getPlayer1().getField();
        parse(field1);
        clearScreen();
        System.out.println("Enter " + game.getPlayer2().getName() + " field:");
        GameField field2 = game.getPlayer2().getField();
        parse(field2);
        clearScreen();
        System.out.println("LET'S FIGHT!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        game.start();
        while (game.isInProgress()) {
            System.out.print((game.isTurn() ? game.getPlayer2().getName() : game.getPlayer1().getName()) + ": ");
            Pair<Integer, Integer> hit = readHit(reader);
            System.out.println(game.move(hit.getKey(), hit.getValue()));
            if (game.isInProgress()) {
                if (!game.isTurn()) {
                    System.out.println(view.fieldView(field1, true));
                } else {
                    System.out.println(view.fieldView(field2, true));
                }
            } else {
                System.out.println("Поздравляю с победой, " + (game.isTurn() ? game.getPlayer2().getName() : game.getPlayer1().getName()));
            }
        }
    }

    private static void parse(GameField field) {
        try {
            FieldReader.parse(readField()).forEach(field::addShip);
        } catch (Exception e) {
            System.out.println("Ошибка при вводе поля! Пожалуйста, введите заново.");
            parse(field);
        }
    }

    private static List<String> readField() throws IOException {
        List<String> result = new ArrayList<>(10);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            result.add(reader.readLine());
        }
        return result;
    }

    private static void clearScreen() {
        System.out.println(new String(new char[80]).replace("\0", "\r\n"));
    }

    private static Pair<Integer, Integer> readHit(BufferedReader reader) throws IOException {
        String[] xy = reader.readLine().split(" ");
        return new Pair<>(Integer.parseInt(xy[1]) - 1, Integer.parseInt(xy[0]) - 1);
    }
}
