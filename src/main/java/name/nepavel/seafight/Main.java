package name.nepavel.seafight;

import name.nepavel.seafight.core.Game;
import name.nepavel.seafight.core.Player;
import name.nepavel.seafight.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        ConsoleView view = new ConsoleView(game);
        game.setPlayer1(new Player("Pavel"));
        game.setPlayer2(new Player("Sasha"));

        game.getPlayer1().getField().getField()[2][5].setShot(true);

        System.out.println(view.fieldView(game.getPlayer1().getField()));
    }
}
