package gwent.service;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Round {

    private int round = 1;
    private boolean turn;
    private boolean turnPass = false;

    public Round() {
        this.turn = draw();
    }

    public int getRound() {
        return round;
    }

    public boolean getTurn() {
        return turn;
    }

    public boolean getTurnPass() {
        return turnPass;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void setTurnPass(boolean turnPass) {
        this.turnPass = turnPass;
    }

    private boolean draw(){
        return Math.random() < 0.5;
    }


}
