package gwent.Card.Spell;

import gwent.Card.Card;
import gwent.Card.Fraction.Fraction;
import gwent.Card.Rarity.Rarity;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Spell extends Card{

    public Spell(String name, String description, Fraction fraction, Rarity rarity) {
        super(name, description, fraction, rarity);
    }
}
