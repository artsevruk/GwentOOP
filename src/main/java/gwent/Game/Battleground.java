package gwent.Game;

import gwent.Card.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by artsevruk on 05.09.2017.
 */
public class Battleground {
    private static Battleground ourInstance = new Battleground();

    private ArrayList<Card> meleeRowPlayerOne;
    private ArrayList<Card> rangeRowPlayerOne;
    private ArrayList<Card> siegeRowPlayerOne;
    private ArrayList<Card> meleeRowPlayerTwo;
    private ArrayList<Card> rangeRowPlayerTwo;
    private ArrayList<Card> siegeRowPlayerTwo;

    private Battleground() {
    }

    public static Battleground getInstance() {
        return ourInstance;
    }

    public ArrayList<Card> getMeleeRowPlayerOne() {
        return meleeRowPlayerOne;
    }

    public ArrayList<Card> getMeleeRowPlayerTwo() {
        return meleeRowPlayerTwo;
    }

    public ArrayList<Card> getRangeRowPlayerOne() {
        return rangeRowPlayerOne;
    }

    public ArrayList<Card> getRangeRowPlayerTwo() {
        return rangeRowPlayerTwo;
    }

    public ArrayList<Card> getSiegeRowPlayerOne() {
        return siegeRowPlayerOne;
    }

    public ArrayList<Card> getSiegeRowPlayerTwo() {
        return siegeRowPlayerTwo;
    }

    public void setMeleeRowPlayerOne(ArrayList<Card> meleeRowPlayerOne) {
        this.meleeRowPlayerOne = meleeRowPlayerOne;
    }

    public void setMeleeRowPlayerTwo(ArrayList<Card> meleeRowPlayerTwo) {
        this.meleeRowPlayerTwo = meleeRowPlayerTwo;
    }

    public void setRangeRowPlayerOne(ArrayList<Card> rangeRowPlayerOne) {
        this.rangeRowPlayerOne = rangeRowPlayerOne;
    }

    public void setRangeRowPlayerTwo(ArrayList<Card> rangeRowPlayerTwo) {
        this.rangeRowPlayerTwo = rangeRowPlayerTwo;
    }

    public void setSiegeRowPlayerOne(ArrayList<Card> siegeRowPlayerOne) {
        this.siegeRowPlayerOne = siegeRowPlayerOne;
    }

    public void setSiegeRowPlayerTwo(ArrayList<Card> siegeRowPlayerTwo) {
        this.siegeRowPlayerTwo = siegeRowPlayerTwo;
    }


    private void setCardCreatureOnRowOfPosition(Card card, Round round, Roweble roweble, ArrayList<Card> rowPositionOfPlayer)
    {
        if (((Creature) card).getPosition() == roweble)
        {
            if (round.getTurn()) rowPositionOfPlayer.add(card);
        }
    }

    public void addCardOnRow(Card card, Round round, ArrayList<Card> rowPositionOfPlayer)
    {
        if (card instanceof Creature)
        {
            setCardCreatureOnRowOfPosition(card, round, Roweble.MELLE, rowPositionOfPlayer);
            setCardCreatureOnRowOfPosition(card, round, Roweble.RANGE, rowPositionOfPlayer);
            setCardCreatureOnRowOfPosition(card, round, Roweble.SIEGE, rowPositionOfPlayer);

            if (((Creature) card).getPosition() == Roweble.ANYROW)
            {
                Random random = new Random();
                int i = random.nextInt(3);
                if (i == 0)setCardCreatureOnRowOfPosition(card, round, Roweble.MELLE, rowPositionOfPlayer);
                else if (i == 1)setCardCreatureOnRowOfPosition(card, round, Roweble.RANGE, rowPositionOfPlayer);
                else if (i == 2)setCardCreatureOnRowOfPosition(card, round, Roweble.SIEGE, rowPositionOfPlayer);
            }
        }

        else if (card instanceof Spell)
        {
            // TODO
        }

    }

    public int getCardPowerOnRowInEndRound(ArrayList<Card> row)
    {
        int cardPowerInRow = 0;
        for (int i = 0; i < row.size(); i++)
        {
            if (row.get(i) instanceof Creature){
                cardPowerInRow = ((Creature) row.get(i)).getCardPower();
                System.out.println("cardPower + " + ((Creature) row.get(i)).getCardPower());
            }
        }
        return cardPowerInRow;
    }

    public int getCardPowerOnBattlergroundInEndRoundForPlayer(ArrayList<Card> meleeRowPlayer, ArrayList<Card> rangeRowPlayer, ArrayList<Card> siegeRowPlayer)
    {
        return getCardPowerOnRowInEndRound(meleeRowPlayer) + getCardPowerOnRowInEndRound(rangeRowPlayer) + getCardPowerOnRowInEndRound(siegeRowPlayer);
    }

}
