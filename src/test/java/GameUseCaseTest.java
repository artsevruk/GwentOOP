import gwent.Card.Card;
import gwent.Card.Collection.Collection;
import gwent.Card.Creature.Creature;
import gwent.Card.Creature.Lord;
import gwent.Card.Deck.Deck;
import gwent.Card.Fraction.Monsters;
import gwent.Card.Rarity.Rarity;
import gwent.Card.Roweble.Roweble;
import gwent.Game.Game;
import gwent.Game.Player;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by artsevruk on 05.09.2017.
 */
public class GameUseCaseTest {

    final static Logger logger = Logger.getLogger(GameUseCaseTest.class);

    Monsters monsters = new Monsters();

    Collection collection = new Collection();

    Game game = new Game();

    Creature creature1 = new Creature("Card1", "Карта первая", monsters, Rarity.BRONZE, 5, Roweble.MELLE);
    Creature creature2 = new Creature("Card2", "Карта вторая", monsters, Rarity.SILVER, 3, Roweble.RANGE);
    Creature creature3 = new Creature("Card3", "Карта трейтья", monsters, Rarity.GOLD, 6, Roweble.SIEGE);
    Creature creature4 = new Creature("Card4", "Карта четвертая", monsters, Rarity.GOLD, 6, Roweble.SIEGE);
    Creature creature5 = new Creature("Card5", "Карта пятая", monsters, Rarity.GOLD, 6, Roweble.ANYROW);
    Lord lordLeshiy = new Lord("Leshiy", "Лидер колодый, Леший", monsters, Rarity.GOLD, 7);


    @BeforeTest
    public void init() throws Exception {















        Player playerOne = new Player();
        Player playerTwo = new Player();

    }

    @Test
    public void testDeck()
    {
        List<Card> cardsOfDeck = new ArrayList<Card>();
        cardsOfDeck.add(creature1);
        cardsOfDeck.add(creature2);
        cardsOfDeck.add(creature3);
        cardsOfDeck.add(creature4);
        cardsOfDeck.add(creature5);





        Deck deckForPlayerOne = new Deck("Deck for Player One", cardsOfDeck, lordLeshiy);

        System.out.println(cardsOfDeck.get(2));
    }






}
