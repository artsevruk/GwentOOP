package gwent.Game;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Round {

    private int round;
    private boolean turn;

    public int getRound() {
        return round;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }
}