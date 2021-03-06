package gwent.service;

import gwent.model.Card;
import gwent.model.Creature;
import gwent.model.Roweble;

import java.util.ArrayList;

/**
 * Created by artsevruk on 05.09.2017.
 */
public class Battleground {
    private static Battleground ourInstance = new Battleground();

    private ArrayList<Card> meleeRowPlayerOne = new ArrayList<Card>();
    private ArrayList<Card> rangeRowPlayerOne = new ArrayList<Card>();
    private ArrayList<Card> siegeRowPlayerOne = new ArrayList<Card>();
    private ArrayList<Card> meleeRowPlayerTwo = new ArrayList<Card>();
    private ArrayList<Card> rangeRowPlayerTwo = new ArrayList<Card>();
    private ArrayList<Card> siegeRowPlayerTwo = new ArrayList<Card>();


    private Battleground() {
    }

    public static Battleground getInstance() {
        return ourInstance;
    }


    public ArrayList<Card> getMeleeRowPlayerOne() {
        return meleeRowPlayerOne;
    }

    public void setMeleeRowPlayerOne(ArrayList<Card> meleeRowPlayerOne) {
        this.meleeRowPlayerOne = meleeRowPlayerOne;
    }

    public ArrayList<Card> getMeleeRowPlayerTwo() {
        return meleeRowPlayerTwo;
    }

    public void setMeleeRowPlayerTwo(ArrayList<Card> meleeRowPlayerTwo) {
        this.meleeRowPlayerTwo = meleeRowPlayerTwo;
    }

    public ArrayList<Card> getRangeRowPlayerOne() {
        return rangeRowPlayerOne;
    }

    public void setRangeRowPlayerOne(ArrayList<Card> rangeRowPlayerOne) {
        this.rangeRowPlayerOne = rangeRowPlayerOne;
    }

    public ArrayList<Card> getRangeRowPlayerTwo() {
        return rangeRowPlayerTwo;
    }

    public void setRangeRowPlayerTwo(ArrayList<Card> rangeRowPlayerTwo) {
        this.rangeRowPlayerTwo = rangeRowPlayerTwo;
    }

    public ArrayList<Card> getSiegeRowPlayerOne() {
        return siegeRowPlayerOne;
    }

    public void setSiegeRowPlayerOne(ArrayList<Card> siegeRowPlayerOne) {
        this.siegeRowPlayerOne = siegeRowPlayerOne;
    }

    public ArrayList<Card> getSiegeRowPlayerTwo() {
        return siegeRowPlayerTwo;
    }

    public void setSiegeRowPlayerTwo(ArrayList<Card> siegeRowPlayerTwo) {
        this.siegeRowPlayerTwo = siegeRowPlayerTwo;
    }

    private int getCardPowerOnRowInEndRound(ArrayList<Card> row) {
        int cardPowerInRow = 0;
        for (int i = 0; i < row.size(); i++) {
            if (row.get(i) instanceof Creature) {
                cardPowerInRow = cardPowerInRow + ((Creature) row.get(i)).getCardPower();
            }
        }
        return cardPowerInRow;
    }

    public int getCardPowerOnBattlergroundInEndRoundForPlayer(ArrayList<Card> meleeRowPlayer, ArrayList<Card> rangeRowPlayer, ArrayList<Card> siegeRowPlayer) {
        return getCardPowerOnRowInEndRound(meleeRowPlayer) + getCardPowerOnRowInEndRound(rangeRowPlayer) + getCardPowerOnRowInEndRound(siegeRowPlayer);
    }


    private void definedPositionCard(Card card, Roweble roweble, ArrayList<Card> position) {
        if (((Creature) card).getPosition() == roweble) {
            position.add(card);
        }
    }


    public void putCardOnBattleground(Card card, ArrayList<Card> mellePosition, ArrayList<Card> rangePosition, ArrayList<Card> siegePosition) {
        if (card instanceof Creature) {
            definedPositionCard(card, Roweble.MELLE, mellePosition);
            definedPositionCard(card, Roweble.RANGE, rangePosition);
            definedPositionCard(card, Roweble.SIEGE, siegePosition);

        }
    }


}
