import gwent.model.*;

import gwent.model.Fraction.Monsters;
import gwent.model.Fraction.NorthernRealm;
import gwent.model.Fraction.Scoiatael;
import gwent.model.Fraction.Skellige;
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

    public GameUseCaseTest() throws IOException {
    }

    @BeforeTest
    public void init() throws IOException {


    }

    @Test
    public void createCollectionUseCaseTest() throws IOException {
        Collection newCollection = new Collection();
        newCollection.printCollection();
    }

    @Test
    public void deckGenerateUseCaseTest() throws IOException {

        collection.addDecks(collection.deckGenerator("First deck on deckGenerator", new Skellige(), collection.getLeaderByFraction(new Skellige())));
    }


    @Test
    public void gameUseCaseTest() throws IOException {

        collection.initCollection();

        Deck deckOfMonsters = collection.deckGenerator("Deck on Monsters", new Monsters(), collection.getLeaderByFraction(new Monsters()));
        Deck deckOfNorthernRealm = collection.deckGenerator("Deck on NorthernRealm", new NorthernRealm(), collection.getLeaderByFraction(new NorthernRealm()));
        collection.addDecks(deckOfMonsters);
        collection.addDecks(deckOfNorthernRealm);

        System.out.println(deckOfMonsters.getCards().size());
        System.out.println(deckOfNorthernRealm.getCards().size());

        Player playerOne = new Player("PlayerOne", deckOfMonsters);
        Player playerTwo = new Player("PlayerTwo", deckOfNorthernRealm);

        Game game = new Game(battleground, playerOne, playerTwo, new Round());

        game.game();



    }
}
