package gwent.model;

import gwent.Id;
import gwent.model.Fraction.Fraction;

/**
 * Created by artsevruk on 04.09.2017.
 */
public abstract class Card extends Id {
    private String name;
    private String description;
    private Fraction fraction;
    private Rarity rarity;

    public Card(String name, String description, Fraction fraction, Rarity rarity) {
        this.name = name;
        this.description = description;
        this.fraction = fraction;
        this.rarity = rarity;
    }

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

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", fraction=" + fraction.getName() +
                ", rarity=" + rarity +
                '}';
    }

}
