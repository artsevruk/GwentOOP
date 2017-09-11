package gwent.model;

import gwent.model.Fraction.Fraction;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Lord extends Creature {

    public Lord(String name, String description, Fraction fraction, Rarity rarity, int cardPower) {
        super(name, description, fraction, rarity, cardPower, Roweble.LEADER);
    }
}