import gwent.model.*;

import gwent.model.Fraction.*;
import gwent.service.Battleground;
import gwent.service.Game;
import gwent.service.Player;
import gwent.service.Round;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import util.CardsDataProvider;

import java.io.IOException;

/**
 * Created by artsevruk on 05.09.2017.
 */
public class GameUseCaseTest {

    final static Logger logger = Logger.getLogger(GameUseCaseTest.class);
    Battleground battleground = Battleground.getInstance();

    Deck deckMonsters = new Deck("Custom deck", new Monsters(), new Leader("LESHIY" , "Leader for custom deck Monsters", new Monsters(), 8));
    Deck deckSkellige = new Deck("Custom deck", new Skellige(), new Leader("CRACH AN CRAITE" , "Leader for custom deck Skellige", new Monsters(), 8));



    @Test(dataProvider = "CustomMonsters", dataProviderClass = CardsDataProvider.class)
    public void createCustomDeckUseCaseTest(Card cardsMonsters, Card cardsSkellige)
    {
        deckMonsters.addCardInDeck(cardsMonsters);

        deckSkellige.addCardInDeck(cardsSkellige);

    }


    @Test
    public void createCollectionUseCaseTest() throws IOException {
        Collection newCollection = new Collection();
        newCollection.printCollection();
    }

    @Test
    public void deckGenerateUseCaseTest() throws IOException {
        Collection collection = new Collection();

        collection.addDecks(collection.deckGenerator("First deck on deckGenerator", new Skellige(), collection.getLeaderByFraction(new Skellige())));
    }

    @Test
    public void gameWithCustomDecksUseCase()
    {
        Player playerOne = new Player("PlayerOneWithCustomDecks", deckMonsters);
        Player playerTwo = new Player("PlayerTwoWithCustomDecks", deckSkellige);
        Game game = new Game(battleground, playerOne, playerTwo, new Round());
        game.game();
    }

    @Test
    public void gameUseCaseTest() throws IOException {
        Collection collection = new Collection();
        collection.initCollection();
        Deck deckOfMonsters = collection.deckGenerator("Deck on Monsters", new Monsters(), collection.getLeaderByFraction(new Monsters()));
        Deck deckOfNorthernRealm = collection.deckGenerator("Deck on NorthernRealm", new NorthernRealm(), collection.getLeaderByFraction(new NorthernRealm()));
        collection.addDecks(deckOfMonsters);
        collection.addDecks(deckOfNorthernRealm);
        Player playerOne = new Player("PlayerOne", deckOfMonsters);
        Player playerTwo = new Player("PlayerTwo", deckOfNorthernRealm);
        Game game = new Game(battleground, playerOne, playerTwo, new Round());
        game.game();

    }
}
