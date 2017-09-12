package gwent.model;

import gwent.model.Fraction.Fraction;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Deck extends Id {

    final static Logger logger = Logger.getLogger(Deck.class);

    protected String name;
    protected Fraction fraction;
    protected List<Card> cards = new ArrayList<Card>();
    protected Leader leader;

    public Deck(String name, Fraction fraction, Leader leader) {
        this.name = name;
        this.fraction = fraction;
        this.leader = leader;
    }

    public Deck(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Leader getLeader() {
        return leader;
    }

    public Fraction getFraction() {
        return fraction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public void setCards(Card card) {
        this.cards.add(card);
        System.out.println("set cards surifully");
    }

    public int[] howRarityCardsInDeck() {
        int[] countrsRarityCards = new int[3];
        return countrsRarityCards;
    }

    public void addCardInDeck(Card card) {
        int counterSilver = 0;
        int conterGold = 0;

        if (cards.size() < 45) {
            if (card.getRarity().equals(Rarity.SILVER)) {
                if (counterSilver <= 6) {
                    cards.add(card);
                    counterSilver++;
                    //logger.info(" added in deck " + card.getName() + " is rarity a " + card.getRarity());
                }

            } else if (card.getRarity().equals(Rarity.GOLD)) {
                if (conterGold <= 4) {
                    cards.add(card);
                    conterGold++;

                }

            } else {
                cards.add(card);
                //logger.info(" added in deck " + card.getName() + " is rarity a " + card.getRarity());
            }

        } else
            logger.info("cards in deck " + name + " : " + cards.size() + ". Bronze: " + (cards.size() - counterSilver - conterGold) + "Silver: " + counterSilver + conterGold);
    }

    public void addListCardsInDeck(ArrayList<Card> cardsList) {
        for (int i = 0; i < cardsList.size() - 1; i++) {
            addCardInDeck(cardsList.get(i));
        }
    }

    public void addLordInDeck(Leader leader) {
        if (this.fraction.equals(leader.getFraction())) {
            this.leader = leader;
        }
    }


}
