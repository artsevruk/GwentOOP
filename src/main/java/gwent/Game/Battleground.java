package gwent.Game;

import gwent.Card.Card;

import java.util.List;

/**
 * Created by artsevruk on 05.09.2017.
 */
public class Battleground {
    private static Battleground ourInstance = new Battleground();

    private List<Card> meleeRowPlayerOne;
    private List<Card> meleeRowPlayerTwo;
    private List<Card> rangeRowPlayerOne;
    private List<Card> rangeRowPlayerTwo;
    private List<Card> siegeRowPlayerOne;
    private List<Card> siegeRowPlayerTwo;

    private Battleground() {
    }

    public static Battleground getInstance() {
        return ourInstance;
    }

    public List<Card> getMeleeRowPlayerOne() {
        return meleeRowPlayerOne;
    }

    public List<Card> getMeleeRowPlayerTwo() {
        return meleeRowPlayerTwo;
    }

    public List<Card> getRangeRowPlayerOne() {
        return rangeRowPlayerOne;
    }

    public List<Card> getRangeRowPlayerTwo() {
        return rangeRowPlayerTwo;
    }

    public List<Card> getSiegeRowPlayerOne() {
        return siegeRowPlayerOne;
    }

    public List<Card> getSiegeRowPlayerTwo() {
        return siegeRowPlayerTwo;
    }

    public void setMeleeRowPlayerOne(List<Card> meleeRowPlayerOne) {
        this.meleeRowPlayerOne = meleeRowPlayerOne;
    }

    public void setMeleeRowPlayerTwo(List<Card> meleeRowPlayerTwo) {
        this.meleeRowPlayerTwo = meleeRowPlayerTwo;
    }

    public void setRangeRowPlayerOne(List<Card> rangeRowPlayerOne) {
        this.rangeRowPlayerOne = rangeRowPlayerOne;
    }

    public void setRangeRowPlayerTwo(List<Card> rangeRowPlayerTwo) {
        this.rangeRowPlayerTwo = rangeRowPlayerTwo;
    }

    public void setSiegeRowPlayerOne(List<Card> siegeRowPlayerOne) {
        this.siegeRowPlayerOne = siegeRowPlayerOne;
    }

    public void setSiegeRowPlayerTwo(List<Card> siegeRowPlayerTwo) {
        this.siegeRowPlayerTwo = siegeRowPlayerTwo;
    }

}
