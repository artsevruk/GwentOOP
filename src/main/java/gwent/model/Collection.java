package gwent.model;

import gwent.model.Fraction.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Collection {
    protected ArrayList<Card> cards = new ArrayList<Card>();
    protected ArrayList<Lord> lords = new ArrayList<Lord>();
    protected ArrayList<Deck> decks = new ArrayList<Deck>();

    public List<Card> getCards() {
        return cards;
    }

    public ArrayList<Lord> getLords() {
        return lords;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void addCards(Card card) {
        this.cards.add(card);
    }

    public void addCards(List<Card> cards) {

        for (int i = 0; i < cards.size(); i++) {
            addCards(cards.get(i));
        }
    }

    public void addLords(Lord lord) {
        this.lords.add(lord);
    }

    public void addDecks(Deck deck) {
        this.decks.add(deck);
    }

    private Fraction howFraction(String fraction) {
        if (fraction.equals("Monsters")) {
            return new Monsters();
        } else if (fraction.equals("Scoiatae")) {
            return new Scoiatael();
        } else if (fraction.equals("NorthernRealm")) {
            return new NorthernRealm();
        } else if (fraction.equals("Skellige")) {
            return new Skellige();
        } else {
            return new Neutral();
        }
    }

    private Rarity howRarity(String rarity) {
        if (rarity.equals("SILVER")) {
            return Rarity.SILVER;
        } else if (rarity.equals("GOLD")) {
            return Rarity.GOLD;
        } else {
            return Rarity.BRONZE;
        }
    }

    private Roweble howRoweble(String row) {
        if (row.equals("RANGE")) {
            return Roweble.RANGE;
        } else if (row.equals("GOLD")) {
            return Roweble.SIEGE;
        } else {
            return Roweble.MELLE;
        }
    }

    public void initCollection() throws IOException {
        Reader reader = new Reader();
        ArrayList<String> nameCard = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 0, 0);
        ArrayList<String> descriptionCard = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 0, 1);
        ArrayList<String> fractionCard = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 0, 2);
        ArrayList<String> rarityCard = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 0, 3);
        ArrayList<String> powerCard = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 0, 4);
        ArrayList<String> rowebleCard = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 0, 5);

        for (int i = 0; i < nameCard.size(); i++) {
            cards.add(new Creature(nameCard.get(i), descriptionCard.get(i), howFraction(fractionCard.get(i)), howRarity(rarityCard.get(i)), Integer.parseInt(powerCard.get(i).substring(0, powerCard.get(0).length() - 2)), howRoweble(rowebleCard.get(i))));
        }
    }

    public Deck deckGenerator(String name, Fraction fraction, Lord lord) {
        int counterMinCards = 0;
        Deck deck = new Deck(name, fraction, lord);

        for (int i = 0; counterMinCards < 20; i++) {
            if (cards.get(i).getFraction().getName().equals(fraction.getName())) {
                deck.addCardInDeck(cards.get(i));
                counterMinCards++;
            }
        }
        return deck;
    }

}
