package gwent.Card.Deck;

import com.sun.org.apache.bcel.internal.generic.LOR;
import gwent.Card.Card;
import gwent.Card.Creature.Lord;
import gwent.Id;

import java.util.List;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Deck extends Id {

    protected String name;
    protected List<Card> cards;
    protected Lord lord;

    public Deck(String name, List<Card> cards, Lord lord) {
        this.name = name;
        this.cards = cards;
        this.lord = lord;
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

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setLord(Lord lord) {
        this.lord = lord;
    }

    public void addCardsInDeck(Card card)
    {
        cards.add(card);
    }
}
