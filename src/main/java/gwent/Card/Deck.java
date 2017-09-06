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
    protected List<Card> cards = new ArrayList<Card>();
    protected Lord lord;

    public Deck(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
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

    public void addCardInDeck(Card card)
    {
        cards.add(card);
    }



}
