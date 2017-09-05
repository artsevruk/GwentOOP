package gwent.Game;


import gwent.Card.Deck;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Game {

    private Battleground battleGround;
    private Player playerOne;
    private Player playerTwo;
    private Round round;

    public Battleground getBattleGround() {
        return battleGround;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Round getRound() {
        return round;
    }

    public void setBattleGround(Battleground battleGround) {
        this.battleGround = battleGround;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public void setRound(Round round) {
        this.round = round;
    }




}
