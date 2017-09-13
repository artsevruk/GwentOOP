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
    private int[] pointsPlayers = new int[2];

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

    public int randomNumber(int max) {

        return (int) (Math.random() * max);
    }

    private void rowBuff(Card card, Card cardOnDesk) {
        if (cardOnDesk instanceof Creature)
            ((Creature) cardOnDesk).setCardPower(((Creature) cardOnDesk).getCardPower() + ((Spell) card).getBuf());
    }

    private void turnSpell(Card card, ArrayList<Card> mellePosition, ArrayList<Card> rangePosition, ArrayList<Card> siegePosition) {

    }

    public void turnPlayerOne() {


        if (playerOne.getCardsOnHand().size() > 0) {


            int numberCardForPlayerOne = randomNumber(playerOne.getCardsOnHand().size());
            Card card = playerOne.getCardsOnHand().get(numberCardForPlayerOne);
            if (card instanceof Creature) {

                battleground.putCardOnBattleground(card, battleground.getMeleeRowPlayerOne(), battleground.getRangeRowPlayerOne(), battleground.getSiegeRowPlayerOne());
                logger.info(playerOne.getName() + " turn card Creature: " + card.getName() + " " + card.getFraction().getName() + ", power is " + ((Creature) card).getCardPower() + ", on position " + ((Creature) card).getPosition());

            } else if (card instanceof Spell) {
                if (((Spell) card).getNumberRow() == 1) {

                    for (int i = 0; i < battleground.getMeleeRowPlayerOne().size(); i++) {
                        Card cardOnDesk = battleground.getMeleeRowPlayerOne().get(i);
                        rowBuff(card, cardOnDesk);
                    }
                    logger.info(playerOne.getName() + " using Spell card" + " - " + card.getName() + " " + card.getFraction().getName() + " +" + ((Spell) card).getBuf() + " all cards in melle row");
                } else if (((Spell) card).getNumberRow() == 2) {
                    for (int i = 0; i < battleground.getRangeRowPlayerOne().size(); i++) {
                        Card cardOnDesk = battleground.getRangeRowPlayerOne().get(i);
                        rowBuff(card, cardOnDesk);
                    }
                    logger.info(playerOne.getName() + " using Spell card" + " - " + card.getName() + " " + card.getFraction().getName() + " +" + ((Spell) card).getBuf() + " all cards in range row");
                } else if (((Spell) card).getNumberRow() == 3) {
                    for (int i = 0; i < battleground.getSiegeRowPlayerOne().size(); i++) {
                        Card cardOnDesk = battleground.getSiegeRowPlayerOne().get(i);
                        rowBuff(card, cardOnDesk);
                    }
                    logger.info(playerOne.getName() + " using Spell card" + " - " + card.getName() + " " + card.getFraction().getName() + " +" + ((Spell) card).getBuf() + " all cards in siege row");
                }
                //logger.info(playerOne.getName() + " turn card on battleground: " + card.getClass().getName()+ " - " + card.getName() + " " + card.getFraction().getName() );
            }

            playerOne.getCardsOnHand().remove(numberCardForPlayerOne);
            //logger.info(playerOne.getName() + " turn card on battleground: " + card.getName() + " " + card.getFraction().getName());
        } else round.setTurnPass(false);
    }

    private void turnPlayerTwo() {
        if (playerTwo.getCardsOnHand().size() > 0) {
            int numberCardForPlayerTwo = randomNumber(playerTwo.getCardsOnHand().size());
            Card card = playerTwo.getCardsOnHand().get(numberCardForPlayerTwo);
            if (card instanceof Creature) {
                battleground.putCardOnBattleground(card, battleground.getMeleeRowPlayerTwo(), battleground.getRangeRowPlayerTwo(), battleground.getSiegeRowPlayerTwo());
                logger.info(playerTwo.getName() + " turn card Creature: " + card.getName() + " " + card.getFraction().getName() + ", power is " + ((Creature) card).getCardPower() + ", on position " + ((Creature) card).getPosition());

            } else if (card instanceof Spell) {
                if (((Spell) card).getNumberRow() == 1) {
                    for (int i = 0; i < battleground.getMeleeRowPlayerTwo().size(); i++) {
                        rowBuff(card, battleground.getMeleeRowPlayerTwo().get(i));
                    }
                    logger.info(playerTwo.getName() + " using Spell card" + " - " + card.getName() + " " + card.getFraction().getName() + " +" + ((Spell) card).getBuf() + " all cards in melle row");
                } else if (((Spell) card).getNumberRow() == 2) {
                    for (int i = 0; i < battleground.getRangeRowPlayerTwo().size(); i++) {
                        rowBuff(card, battleground.getRangeRowPlayerTwo().get(i));
                    }
                    logger.info(playerTwo.getName() + " using Spell card" + " - " + card.getName() + " " + card.getFraction().getName() + " +" + ((Spell) card).getBuf() + " all cards in range row");
                } else if (((Spell) card).getNumberRow() == 3) {
                    for (int i = 0; i < battleground.getSiegeRowPlayerTwo().size(); i++) {
                        rowBuff(card, battleground.getSiegeRowPlayerTwo().get(i));
                    }
                    logger.info(playerTwo.getName() + " using Spell card" + " - " + card.getName() + " " + card.getFraction().getName() + " +" + ((Spell) card).getBuf() + " all cards in siege row");
                }
            }

            playerTwo.getCardsOnHand().remove(numberCardForPlayerTwo);
        } else round.setTurnPass(true);


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
                turnPlayerOne();
                isPassed(countTurn++, numberTurn, playerOne);
                turnPlayerTwo();
                isPassed(countTurn++, numberTurn, playerTwo);
            } else if (!round.getTurn()) {
                turnPlayerTwo();
                isPassed(countTurn++, numberTurn, playerTwo);
                turnPlayerOne();
                isPassed(countTurn++, numberTurn, playerOne);
            }
        }
        pointsPlayers[0] = battleground.getCardPowerOnBattlergroundInEndRoundForPlayer(battleground.getMeleeRowPlayerOne(), battleground.getRangeRowPlayerOne(), battleground.getSiegeRowPlayerOne());
        pointsPlayers[1] = battleground.getCardPowerOnBattlergroundInEndRoundForPlayer(battleground.getMeleeRowPlayerTwo(), battleground.getRangeRowPlayerTwo(), battleground.getSiegeRowPlayerTwo());
        printMessageLogg(pointsPlayers, playerOne.getName() + " is WINNER Round " + round.getRound() + ", with a score of " + pointsPlayers[0] + " : " + pointsPlayers[1] + "!", playerTwo.getName() + " is WINNER Round" + round.getRound() + ", with a score of " + pointsPlayers[0] + " : " + pointsPlayers[1] + "!", "The round ended in a draw, with a score of " + pointsPlayers[0] + " : " + pointsPlayers[1] + "!");

    }


    public void game() {
        logger.info("------------------------------ GAME START");
        logger.info("Draw turn");
        roundOfGame();
        round.setRound(2);
        roundOfGame();
        if (pointsPlayers[0] == pointsPlayers[1]) {
            round.setRound(3);
            roundOfGame();
        }
        printMessageLogg(pointsPlayers, playerOne.getName() + " is WINNER GAME, with a score of " + pointsPlayers[0] + " : " + pointsPlayers[1] + "!", playerTwo.getName() + " is WINNER GAME, with a score of " + pointsPlayers[0] + " : " + pointsPlayers[1] + "!", "The game ended in a draw, with a score of " + pointsPlayers[0] + " : " + pointsPlayers[1] + "!");
        logger.info("--------------------------------------------------------------------------------------------------------------");
    }

    private void printMessageLogg(int[] pointsPlayers, String messageOne, String messageTwo, String messageTрree) {
        if (pointsPlayers[0] > pointsPlayers[1]) logger.info(messageOne);
        else if (pointsPlayers[0] < pointsPlayers[1]) logger.info(messageTwo);
        else logger.info(messageTрree);
    }


}
