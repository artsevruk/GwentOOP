package gwent.service;

import gwent.model.Card;
import gwent.model.Deck;

import java.util.ArrayList;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Player {

    private String name;
    private ArrayList<Card> cardsOnHand = new ArrayList<Card>();
    private ArrayList<Card> deckOfDiscardedCards = new ArrayList<Card>();
    private Deck deck;

    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
        this.cardsOnHand = new ArrayList<Card>();
        this.deckOfDiscardedCards = new ArrayList<Card>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCardsOnHand() {
        return cardsOnHand;
    }

    public ArrayList<Card> getDeckOfDiscardedCards() {
        return deckOfDiscardedCards;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCardsOnHand(ArrayList<Card> cardsOnHand) {
        this.cardsOnHand = cardsOnHand;
    }

    public void setDeckOfDiscardedCards(ArrayList<Card> deckOfDiscardedCards) {
        this.deckOfDiscardedCards = deckOfDiscardedCards;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
