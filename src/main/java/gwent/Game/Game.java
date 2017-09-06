package gwent.Game;


import gwent.Card.Card;
import gwent.Card.Deck;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Game {


    private Battleground battleground;
    private Player playerOne;
    private Player playerTwo;
    private Round round;

    public Game(Battleground battleground, Player playerOne, Player playerTwo, Round round) {
        this.battleground = battleground;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.round = round;
    }

    public Battleground getBattleGround() {
        return battleground;
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
        this.battleground = battleGround;
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

    public void gameRoundeOne()
    {

        int countTurn = 0;
        Random random = new Random();
        int numberTurn = random.nextInt(4) + 2;
        System.out.println("numberTurn: " + numberTurn);


        drawCardsOnHand(playerOne, round);
        drawCardsOnHand(playerTwo, round);

        if (round.draw()) round.setTurn(true);
        else round.setTurn(false);

        System.out.println("round.getTurn: " + round.getTurn());

        while (!round.getTurnPass())
        {
            System.out.println("Start! ");
            if (round.getTurn())
            {

                int numberCardForPlayerOne = random.nextInt(playerOne.getDeck().getCards().size()-1);
                System.out.println("1 numberCardForPlayerOne: " + numberCardForPlayerOne);

                battleground.addCardOnRow(playerOne.getCardsOnHand().get(numberCardForPlayerOne-1), battleground.getMeleeRowPlayerOne(), battleground.getRangeRowPlayerOne(), battleground.getSiegeRowPlayerOne());
                playerOne.getCardsOnHand().remove(numberCardForPlayerOne-1);



                int numberCardForPlayerTwo = random.nextInt(playerTwo.getDeck().getCards().size()-1);
                System.out.println("2 numberCardForPlayerOne: " + numberCardForPlayerTwo);

                battleground.addCardOnRow(playerTwo.getCardsOnHand().get(numberCardForPlayerTwo-1), battleground.getMeleeRowPlayerTwo(), battleground.getRangeRowPlayerTwo(), battleground.getSiegeRowPlayerTwo());
                playerTwo.getCardsOnHand().remove(numberCardForPlayerTwo-1);

                countTurn++;
                if (countTurn == numberTurn) round.setTurnPass(true);
            }


            else if (!round.getTurn())
            {
                int numberCardForPlayerTwo = random.nextInt(playerTwo.getDeck().getCards().size());
                System.out.println("3 numberCardForPlayerOne: " + numberCardForPlayerTwo);

                battleground.addCardOnRow(playerTwo.getCardsOnHand().get(numberCardForPlayerTwo-1), battleground.getMeleeRowPlayerTwo(), battleground.getRangeRowPlayerTwo(), battleground.getSiegeRowPlayerTwo());
                playerTwo.getCardsOnHand().remove(numberCardForPlayerTwo-1);


                int numberCardForPlayerOne = random.nextInt(playerOne.getDeck().getCards().size());
                System.out.println("4 numberCardForPlayerOne: " + numberCardForPlayerOne);

                battleground.addCardOnRow(playerOne.getCardsOnHand().get(numberCardForPlayerOne-1), battleground.getMeleeRowPlayerOne(), battleground.getRangeRowPlayerOne(), battleground.getSiegeRowPlayerOne());
                playerOne.getCardsOnHand().remove(numberCardForPlayerOne-1);

                countTurn++;
                if (countTurn == numberTurn) round.setTurnPass(true);
            }

        }
    }

    public void game()
    {

    }

}
