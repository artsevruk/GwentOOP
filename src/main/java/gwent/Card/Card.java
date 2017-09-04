package gwent.Card;

import gwent.Card.Fraction.Fraction;
import gwent.Card.Rarity.Rarity;
import gwent.Id;

/**
 * Created by artsevruk on 04.09.2017.
 */
public abstract class Card extends Id {
    protected String name;
    protected String description;
    protected Fraction fraction;
    protected Rarity rarity;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Fraction getFraction() {
        return fraction;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFraction(Fraction fraction) {
        this.fraction = fraction;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }
}
