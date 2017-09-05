package gwent.Card.Creature;

import gwent.Card.Card;
import gwent.Card.Fraction.Fraction;
import gwent.Card.Rarity.Rarity;
import gwent.Card.Roweble.Roweble;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Creature extends Card{

    protected int cardPower;
    protected Roweble position;

    public Creature(String name, String description, Fraction fraction, Rarity rarity, int cardPower, Roweble position) {
        super(name, description, fraction, rarity);
        this.cardPower = cardPower;
        this.position = position;
    }


    public int getCardPower() {
        return cardPower;
    }

    public Roweble getPosition() {
        return position;
    }

    public void setCardPower(int cardPower) {
        this.cardPower = cardPower;
    }

    public void setPosition(Roweble position) {
        this.position = position;
    }
}
