package name.nepavel.seafight.core;

public class Game {
    private boolean inProgress;
    private boolean turn; //false means 1st player
    private Player player1;
    private Player player2;

    public void start() {
        inProgress = true;
    }

    public HitResult move(int x, int y) {
        if (!inProgress) {
            return null;
        }
        GameField fieldUnderAttack = turn ? player1.getField() : player2.getField();
        HitResult result = fieldUnderAttack.attack(new Cell(x, y));
        if (result == HitResult.KILLED && fieldUnderAttack.allDead()) {
            inProgress = false;
            return HitResult.WIN;
        }
        turn = !turn;
        return result;
    }

    public void reset() {
        inProgress = false;
        turn = false;
        player1 = null;
        player2 = null;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public boolean isTurn() {
        return turn;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
}
