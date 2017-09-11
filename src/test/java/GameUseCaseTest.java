import gwent.model.*;

import gwent.model.Fraction.Monsters;

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
    Deck deckForPlayerOne = new Deck("Deck for Player One", new Monsters(), new Lord("Lord1", "Первый лорд", new Monsters(), 9));
    Deck deckForPlayerTwo = new Deck("Deck for Player Two", new Scoiatael(), new Lord("Lord2", "Второй лорд", new Scoiatael(), 9));

    @BeforeTest
    public void init() throws IOException {
        //collection.initCollection();
        //collection.addDecks(collection.deckGenerator("Deck on Monsters", new Monsters(), collection.getLordByFraction(new Monsters())));

    }


    @Test
    public void testReader() throws IOException {
        //Reader reader = new Reader();
        //ArrayList<String> strReader = reader.readOfCatlogInList("src/test/resources/DataCards/DataCards.xls",0,4);
        //System.out.println(strReader.size());
        //System.out.println(Integer.parseInt(strReader.get(0).substring(0,strReader.get(0).length()-2)));
        //System.out.println(strReader.get(1));
        System.out.println("size coll: " + collection.getCards().size());
        collection.initCollection();
        System.out.println("size coll: " + collection.getCards().size());
        Deck deck3 = collection.deckGenerator("Deck on Monsters", new Monsters(), collection.getLordByFraction(new Monsters()));
        System.out.println(deck3.getCards().size());
        System.out.println("deck3.getLord().getFraction(): " + deck3.getLord().getFraction().getName());
        System.out.println("deck3.getLord().getName(): " + deck3.getLord().getName());
        System.out.println("deck3.getLord().getFraction(): " + deck3.getFraction().getName());
    }


    @Test
    public void game() {

        Player playerOne = new Player("PlayerOne", deckForPlayerOne);
        Player playerTwo = new Player("PlayerTwo", deckForPlayerTwo);

        Battleground battleground = Battleground.getInstance();

        Game game = new Game(battleground, playerOne, playerTwo, new Round());

        //game.game();

    }

}
