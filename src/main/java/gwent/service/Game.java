package gwent.service;


import gwent.model.Card;
import gwent.model.Creature;
import gwent.model.Spell;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Game {
    final static Logger logger = Logger.getLogger(Game.class);


    private Battleground battleground;
    private Player playerOne;
    private Player playerTwo;
    private Round round;
    private int[] roundPointsPlayers = new int[2];

    public Game(Battleground battleground, Player playerOne, Player playerTwo, Round round) {
        this.battleground = battleground;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.round = round;
    }

    public Battleground getBattleGround() {
        return battleground;
    }

    public void setBattleGround(Battleground battleGround) {
        this.battleground = battleGround;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public void drawCardsOnHand(Player player, Round round) {
        Random random = new Random();
        int count = 0;
        int drawCardsInRounds;

        if (round.getRound() == 1) {
            drawCardsInRounds = 10;
            logger.info("Draw 10 cards" + player.getName());
        } else if (round.getRound() == 2) {
            drawCardsInRounds = 2;
            logger.info("add 2 cards" + player.getName());
        } else {
            drawCardsInRounds = 1;
            logger.info("add 1 cards" + player.getName());
        }

        try {
            while (count < drawCardsInRounds) {
                int i = random.nextInt(player.getDeck().getCards().size());
                player.getCardsOnHand().add(player.getDeck().getCards().get(i));
                player.getDeck().getCards().remove(i);
                count++;
            }
        } catch (IllegalArgumentException e) {
            logger.error("The player does not have a deck." + player.getDeck().getName());
        }

    }

    private int randomNumber(int max) {

        return (int) (Math.random() * max);
    }

    private void rowBuff(Card card, Card cardOnDesk) {
        if (cardOnDesk instanceof Creature)
            ((Creature) cardOnDesk).setCardPower(((Creature) cardOnDesk).getCardPower() + ((Spell) card).getBuf());
    }

    private void buffRow(Player player, Card card, ArrayList<Card> rowPlayer)
    {
        for (int i = 0; i < rowPlayer.size(); i++) {
            rowBuff(card, rowPlayer.get(i));
        }
        logger.info(player.getName() + " using Spell card" + " - " + card.getName() + " " + card.getFraction().getName() + " +" + ((Spell) card).getBuf() + " all cards in melle row");

    }


    private void isNumberRowForSpell(Player player, Card card, ArrayList<Card> meleeRowPlayer, ArrayList<Card> rangeRowPlayer, ArrayList<Card> siegeRowPlayer){
        if (((Spell) card).getNumberRow() == 1) {
            buffRow(player,card,meleeRowPlayer);
        }
        else if (((Spell) card).getNumberRow() == 2) {
            buffRow(player,card,rangeRowPlayer);
        }
        else if (((Spell) card).getNumberRow() == 3) {
            buffRow(player,card,siegeRowPlayer);
        }

    }


    public void turnPlayer(Player player, ArrayList<Card> meleeRowPlayer, ArrayList<Card> rangeRowPlayer, ArrayList<Card> siegeRowPlayer)
    {

        if (player.getCardsOnHand().size() > 0) {
            int numberCardForPlayer = randomNumber(player.getCardsOnHand().size());
            Card card = player.getCardsOnHand().get(numberCardForPlayer);
            if (card instanceof Creature) {
                battleground.putCardOnBattleground(card, meleeRowPlayer, rangeRowPlayer, siegeRowPlayer);
                logger.info(player.getName() + " turn card Creature: " + card.getName() + " " + card.getFraction().getName() + ", power is " + ((Creature) card).getCardPower() + ", on position " + ((Creature) card).getPosition());
            }
            else if (card instanceof Spell) {
                isNumberRowForSpell(player, card, meleeRowPlayer, rangeRowPlayer, siegeRowPlayer);
            }

            player.getCardsOnHand().remove(numberCardForPlayer);
        }
        else round.setTurnPass(false);
    }


    private void isPassed(int counter, int numberTurn, Player player) {
        if (counter == numberTurn) {
            round.setTurnPass(true);
            logger.info(player.getName() + " is PASSED");
        }
    }

    private void roundOfGame() {
        logger.info("Round " + round.getRound());
        int countTurn = 0;
        int numberTurn = randomNumber(4) + 3;
        round.setTurnPass(false);
        drawCardsOnHand(playerOne, round);
        drawCardsOnHand(playerTwo, round);
        if (round.getTurn()) logger.info("First turn " + playerOne.getName());
        else logger.info("First turn " + playerTwo.getName());
        while (!round.getTurnPass()) {
            if (round.getTurn()) {
                turnPlayer(playerOne, battleground.getMeleeRowPlayerOne(), battleground.getRangeRowPlayerOne(), battleground.getSiegeRowPlayerOne());
                isPassed(countTurn++, numberTurn, playerOne);
                turnPlayer(playerTwo, battleground.getSiegeRowPlayerTwo(), battleground.getSiegeRowPlayerTwo(), battleground.getSiegeRowPlayerTwo());
                isPassed(countTurn++, numberTurn, playerTwo);
            } else if (!round.getTurn()) {
                turnPlayer(playerTwo, battleground.getSiegeRowPlayerTwo(), battleground.getSiegeRowPlayerTwo(), battleground.getSiegeRowPlayerTwo());
                isPassed(countTurn++, numberTurn, playerTwo);
                turnPlayer(playerOne, battleground.getMeleeRowPlayerOne(), battleground.getRangeRowPlayerOne(), battleground.getSiegeRowPlayerOne());
                isPassed(countTurn++, numberTurn, playerOne);
            }
        }


        int pointsPlayerOne = battleground.getCardPowerOnBattlergroundInEndRoundForPlayer(battleground.getMeleeRowPlayerOne(), battleground.getRangeRowPlayerOne(), battleground.getSiegeRowPlayerOne());
        int pointsPlayerTwo = battleground.getCardPowerOnBattlergroundInEndRoundForPlayer(battleground.getMeleeRowPlayerTwo(), battleground.getRangeRowPlayerTwo(), battleground.getSiegeRowPlayerTwo());

        addPointsPlayers(pointsPlayerOne,pointsPlayerTwo);

        printMessageLogg(pointsPlayerOne, pointsPlayerTwo,playerOne.getName() + " is WINNER Round " + round.getRound() + ", with a score of " + pointsPlayerOne + " : " + pointsPlayerTwo + "!", playerTwo.getName() + " is WINNER Round " + round.getRound() + ", with a score of " + pointsPlayerOne + " : " + pointsPlayerTwo + "!", "The round ended in a draw, with a score of " + pointsPlayerOne + " : " + pointsPlayerTwo + "!");

    }

    private void addPointsPlayers(int pointPlayerOne, int pointPlayerTwo)
    {

        if (pointPlayerOne > pointPlayerTwo)
        {
            roundPointsPlayers[0]++;
        }
        else if (pointPlayerOne < pointPlayerTwo){
            roundPointsPlayers[1]++;
        }
        else {
            roundPointsPlayers[0]++;
            roundPointsPlayers[1]++;
        }


    }


    public void game() {
        logger.info("------------------------------ GAME START");
        logger.info("Draw turn");
        roundOfGame();
        round.setRound(2);
        roundOfGame();
        if (roundPointsPlayers[0] == roundPointsPlayers[1]) {
            round.setRound(3);
            roundOfGame();
        }
        printMessageLogg(roundPointsPlayers[0], roundPointsPlayers[1], playerOne.getName() + " is WINNER GAME, with a score of " + roundPointsPlayers[0] + " : " + roundPointsPlayers[1] + "!", playerTwo.getName() + " is WINNER GAME, with a score of " + roundPointsPlayers[0] + " : " + roundPointsPlayers[1] + "!", "The game ended in a draw, with a score of " + roundPointsPlayers[0] + " : " + roundPointsPlayers[1] + "!");
        logger.info("--------------------------------------------------------------------------------------------------------------");
    }

    private void printMessageLogg(int pointsPlayerOne, int pointsPlayerTwo, String messageOne, String messageTwo, String messageTрree) {
        if (pointsPlayerOne > pointsPlayerTwo) logger.info(messageOne);
        else if (pointsPlayerOne < pointsPlayerTwo) logger.info(messageTwo);
        else logger.info(messageTрree);
    }


}
