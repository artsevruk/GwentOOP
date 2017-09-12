import gwent.model.*;

import gwent.model.Fraction.Monsters;
import gwent.model.Fraction.NorthernRealm;
import gwent.model.Fraction.Scoiatael;
import gwent.service.Battleground;
import gwent.service.Game;
import gwent.service.Player;
import gwent.service.Round;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by artsevruk on 05.09.2017.
 */
public class GameUseCaseTest {

    final static Logger logger = Logger.getLogger(GameUseCaseTest.class);
    Collection collection = new Collection();
    Battleground battleground = Battleground.getInstance();

    @BeforeTest
    public void init() throws IOException {
        //collection.initCollection();
        //collection.addDecks(collection.deckGenerator("Deck on Monsters", new Monsters(), collection.getLordByFraction(new Monsters())));

    }


    @Test
    public void testReader() throws IOException {


    }


    @Test
    public void game() throws IOException {


        collection.initCollection();

        Deck deckOfMonsters = collection.deckGenerator("Deck on Monsters", new Monsters(), collection.getLeaderByFraction(new Monsters()));


        Spell spell1 = new Spell("qqq1","www1", new Monsters(), Rarity.GOLD, 1,5);
        Spell spell2 = new Spell("qqq2","www2", new Monsters(), Rarity.GOLD,2,1);
        Spell spell3 = new Spell("qqq3","www3", new Monsters(), Rarity.GOLD,3,2);
        Spell spell4 = new Spell("qqq4","www4", new Monsters(), Rarity.GOLD,4,1);
        deckOfMonsters.addCardInDeck(spell1);
        deckOfMonsters.addCardInDeck(spell2);
        deckOfMonsters.addCardInDeck(spell3);
        deckOfMonsters.addCardInDeck(spell4);






        Deck deckOfNorthernRealm = collection.deckGenerator("Deck on NorthernRealm", new NorthernRealm(), collection.getLeaderByFraction(new NorthernRealm()));
        collection.addDecks(deckOfMonsters);
        collection.addDecks(deckOfNorthernRealm);
        //collection.printCollection();
        System.out.println(deckOfMonsters.getCards().size());
        System.out.println(deckOfNorthernRealm.getCards().size());

        Player playerOne = new Player("PlayerOne", deckOfMonsters);
        Player playerTwo = new Player("PlayerTwo", deckOfNorthernRealm);

        Game game = new Game(battleground, playerOne, playerTwo, new Round());

        game.game();



    }
}
