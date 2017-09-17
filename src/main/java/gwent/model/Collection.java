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
    protected ArrayList<Leader> leaders = new ArrayList<Leader>();
    protected ArrayList<Deck> decks = new ArrayList<Deck>();

    public Collection() throws IOException {
        initCollection();
    }

    public List<Card> getCards() {
        return cards;
    }

    public ArrayList<Leader> getLeaders() {
        return leaders;
    }

    public Leader getLeaderByFraction(Fraction fraction) {
        for (int i = 0; i < leaders.size(); i++) {
            if (leaders.get(i).getFraction().equals(fraction.getName())) {
                return leaders.get(i);
            }
        }
        return leaders.get(0);
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

    public void addLords(Leader leader) {
        this.leaders.add(leader);
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
        ArrayList<String> nameSpell = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 2, 0);
        ArrayList<String> descriptionSpell = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 2, 1);
        ArrayList<String> fractionSpell = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 2, 2);
        ArrayList<String> raritySpell = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 2, 3);
        ArrayList<String> numberBuff = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 2, 4);
        ArrayList<String> buff = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls", 2, 5);

        for (int i = 0; i < nameCards.size(); i++) {
            cards.add(new Creature(nameCards.get(i), descriptionCards.get(i), howFraction(fractionCards.get(i)), howRarity(rarityCards.get(i)), Integer.parseInt(powerCards.get(i).substring(0, powerCards.get(0).length() - 2)), howRoweble(rowebleCards.get(i))));
        }

        for (int i = 0; i < leaderName.size(); i++) {
            leaders.add(new Leader(leaderName.get(i), leaderDescrip.get(i), howFraction(leaderFraction.get(i)), Integer.parseInt(leaderPower.get(i).substring(0, leaderPower.get(0).length() - 2))));
        }

        logger.info("Leaders are added to the collection successfully! Amount leaders: " + getLeaders().size());
        System.out.println("Leaders are added to the collection successfully! Amount leaders: " + getLeaders().size());

        for (int i = 0; i < nameSpell.size(); i++) {
            cards.add(new Spell(nameSpell.get(i), descriptionSpell.get(i), howFraction(fractionSpell.get(i)), howRarity(raritySpell.get(i)), Integer.parseInt(numberBuff.get(i).substring(0, numberBuff.get(0).length() - 2)), Integer.parseInt(buff.get(i).substring(0, buff.get(0).length() - 2))));
        }
        logger.info("Cards are added to the collection successfully! Amount cards: " + getCards().size());
        System.out.println("Cards are added to the collection successfully! Amount cards: " + getCards().size());

    }

    public Deck deckGenerator(String name, Fraction fraction, Leader leader) {
        int counterMinCards = 0;
        Deck deck = new Deck(name, fraction, leader);

        for (int i = 0; counterMinCards < 20; i++) {
            if (cards.get(i).getFraction().getName().equals(fraction.getName())) {
                deck.addCardInDeck(cards.get(i));
                counterMinCards++;
            }
        }
        logger.info("Deck " + name + " created! ");
        System.out.println("Deck " + name + " created! ");
        return deck;
    }

    public void printCollection() {
        for (int i = 0; i < cards.size(); i++) {
            logger.info("Card name: " + cards.get(i).getName() + ", Fraction: " + cards.get(i).getFraction().getName() + " Rarity: " + cards.get(i).getRarity());
        }
        for (int i = 0; i < decks.size(); i++) {
            logger.info("Deck name: " + decks.get(i).getName() + ", Fraction: " + decks.get(i).getFraction().getName());
        }
        for (int i = 0; i < leaders.size(); i++) {
            logger.info("Leader name: " + leaders.get(i).getName() + ", Fraction: " + leaders.get(i).getFraction().getName() + " Rarity: " + leaders.get(i).getRarity());
        }
    }

}
