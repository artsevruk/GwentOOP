package gwent.Game;


import gwent.Card.Card;
import gwent.Card.Deck;

import java.util.Calendar;
import java.util.Random;

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

    public void drawCardsOnHand(Player player, Round round)
    {
        Random random = new Random();
        int count = 0;
        int drawCardsInRounds;

        if (round.getRound() == 1) drawCardsInRounds = 10;
        else if(round.getRound() == 2) drawCardsInRounds = 2;
        else drawCardsInRounds = 1;

        while (count < drawCardsInRounds)
        {
            int i = random.nextInt(player.getDeck().getCards().size());
            player.getCardsOnHand().add(player.getDeck().getCards().get(i));
            player.getDeck().getCards().remove(i);
            count++;
        }

    }

    public void drawCardOnBattleground(Battleground battleground, Card card)
    {

    }

}
