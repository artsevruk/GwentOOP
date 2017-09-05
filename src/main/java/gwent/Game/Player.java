package gwent.Game;

import gwent.Card.Card;
import gwent.Card.Deck;

import java.util.List;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Player {

    private String name;
    private List<Card> cardsOnHand;
    private List<Card> deckOfDiscardedCards;
    private Deck deck;

    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
    }

    public String getName() {
        return name;
    }

    public List<Card> getCardsOnHand() {
        return cardsOnHand;
    }

    public List<Card> getDeckOfDiscardedCards() {
        return deckOfDiscardedCards;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCardsOnHand(List<Card> cardsOnHand) {
        this.cardsOnHand = cardsOnHand;
    }

    public void setDeckOfDiscardedCards(List<Card> deckOfDiscardedCards) {
        this.deckOfDiscardedCards = deckOfDiscardedCards;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
