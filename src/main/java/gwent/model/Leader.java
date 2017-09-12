package gwent.model;

import gwent.model.Fraction.Fraction;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Leader extends Creature {

    public Leader(String name, String description, Fraction fraction, int cardPower) {
        super(name, description, fraction, Rarity.GOLD, cardPower, Roweble.ANYROW);
    }
}
