package gwent.Card;

import gwent.Card.Card;
import gwent.Card.Deck;

import java.util.List;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Collection {
    protected List<Card> cards;
    protected List<Card> deck;
    protected List<Deck> decks;

    public List<Card> getCards() {
        return cards;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }

}