package gwent.Card;

import gwent.Card.Creature;
import gwent.Card.Fraction.Fraction;
import gwent.Card.Rarity;
import gwent.Card.Roweble;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Lord extends Creature {

    public Lord(String name, String description, Fraction fraction, Rarity rarity, int cardPower) {
        super(name, description, fraction, rarity, cardPower, Roweble.LEADER);
    }
}
