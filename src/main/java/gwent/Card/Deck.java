package gwent.Card;

import gwent.Card.Fraction.Monsters;
import gwent.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Deck extends Id {

    protected String name;
    protected List<Creature> cardsCreature = new ArrayList<Creature>();
    protected List<Spell> cardsSpell= new ArrayList<Spell>();
    protected Lord lord;

    public Deck(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Creature> getCardsCreature() {
        return cardsCreature;
    }

    public List<Spell> getCardsSpell() {
        return cardsSpell;
    }

    public Lord getLord() {
        return lord;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLord(Lord lord) {
        this.lord = lord;
    }

    public void addCardCreatureInDeck(Creature creature)
    {
        cardsCreature.add(creature);
    }

    public void addCardSpellInDeck(Spell spell)
    {
        cardsSpell.add(spell);
    }



}
