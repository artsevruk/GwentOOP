package gwent.model;

import gwent.model.Fraction.*;
import gwent.service.util.Reader;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Collection {
    final static Logger logger = Logger.getLogger(Collection.class);

    protected ArrayList<Card> cards = new ArrayList<Card>();
    protected ArrayList<Lord> lords = new ArrayList<Lord>();
    protected ArrayList<Deck> decks = new ArrayList<Deck>();

    public List<Card> getCards() {
        return cards;
    }

    public ArrayList<Lord> getLords() {
        return lords;
    }

    public Lord getLordByFraction(Fraction fraction) {
        for (int i = 0; i < lords.size(); i++) {
            if (lords.get(i).getFraction().equals(fraction.getName())) {
                return lords.get(i);
            }
        }
        return lords.get(0);
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
        ArrayList<String> nameCards = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 0, 0);
        ArrayList<String> descriptionCards = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 0, 1);
        ArrayList<String> fractionCards = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 0, 2);
        ArrayList<String> rarityCards = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 0, 3);
        ArrayList<String> powerCards = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 0, 4);
        ArrayList<String> rowebleCards = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 0, 5);
        ArrayList<String> leaderName = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 1, 0);
        ArrayList<String> leaderDescrip = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 1, 1);
        ArrayList<String> leaderFraction = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 1, 2);
        ArrayList<String> leaderPower = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 1, 3);

        for (int i = 0; i < nameCards.size(); i++) {
            cards.add(new Creature(nameCards.get(i), descriptionCards.get(i), howFraction(fractionCards.get(i)), howRarity(rarityCards.get(i)), Integer.parseInt(powerCards.get(i).substring(0, powerCards.get(0).length() - 2)), howRoweble(rowebleCards.get(i))));
        }
        logger.info("Cards are added to the collection successfully! Amount cards: " + getCards().size());
        System.out.println("Cards are added to the collection successfully! Amount cards: " + getCards().size());
        for (int i = 0; i < leaderName.size(); i++) {
            lords.add(new Lord(leaderName.get(i), leaderDescrip.get(i), howFraction(leaderFraction.get(i)), Integer.parseInt(powerCards.get(i).substring(0, powerCards.get(0).length() - 2))));

        }

        logger.info("Leaders are added to the collection successfully! Amount leaders: " + getLords().size());
        System.out.println("Leaders are added to the collection successfully! Amount leaders: " + getLords().size());
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
