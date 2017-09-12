package gwent.service;

import gwent.model.Card;
import gwent.model.Deck;
import gwent.model.Leader;

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

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setCardsOnHand(ArrayList<Card> cardsOnHand) {
        this.cardsOnHand = cardsOnHand;
    }

    public void setDeckOfDiscardedCards(Card deckOfDiscardedCards) {
        this.deckOfDiscardedCards.add(deckOfDiscardedCards);
    }

}
