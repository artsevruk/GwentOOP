import gwent.Card.*;
import gwent.Card.Fraction.Monsters;
import gwent.Card.Fraction.Scoiatael;
import gwent.Game.Battleground;
import gwent.Game.Game;
import gwent.Game.Player;
import gwent.Game.Round;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;



/**
 * Created by artsevruk on 05.09.2017.
 */
public class GameUseCaseTest {

    final static Logger logger = Logger.getLogger(GameUseCaseTest.class);


    @Test
    public void game()
    {


        Deck deckForPlayerOne = new Deck("Deck for Player One");
        Deck deckForPlayerTwo = new Deck("Deck for Player Two");

        Player playerOne = new Player("PlayerOne", deckForPlayerOne);
        Player playerTwo = new Player("PlayerTwo", deckForPlayerTwo);


        deckForPlayerOne.addCardInDeck(new Creature("Card1", "Карта первая", new Monsters(), Rarity.BRONZE, 1, Roweble.MELLE));
        deckForPlayerOne.addCardInDeck(new Creature("Card2", "Карта вторая", new Monsters(), Rarity.SILVER, 2, Roweble.RANGE));
        deckForPlayerOne.addCardInDeck(new Creature("Card3", "Карта третья", new Monsters(), Rarity.GOLD, 3, Roweble.SIEGE));
        deckForPlayerOne.addCardInDeck(new Creature("Card4", "Карта четвертая", new Monsters(), Rarity.BRONZE, 4, Roweble.SIEGE));
        deckForPlayerOne.addCardInDeck(new Creature("Card5", "Карта пятая", new Monsters(), Rarity.SILVER, 5, Roweble.RANGE));
        deckForPlayerOne.addCardInDeck(new Creature("Card6", "Карта шестая", new Monsters(), Rarity.GOLD, 6, Roweble.MELLE));
        deckForPlayerOne.addCardInDeck(new Creature("Card7", "Карта седьмая", new Monsters(), Rarity.BRONZE, 7, Roweble.RANGE));
        deckForPlayerOne.addCardInDeck(new Creature("Card8", "Карта восьмая", new Monsters(), Rarity.SILVER, 8, Roweble.SIEGE));
        deckForPlayerOne.addCardInDeck(new Creature("Card9", "Карта девятая", new Monsters(), Rarity.GOLD, 9, Roweble.MELLE));
        deckForPlayerOne.addCardInDeck(new Creature("Card10", "Карта десятая", new Monsters(), Rarity.BRONZE, 10, Roweble.SIEGE));
        deckForPlayerOne.addCardInDeck(new Creature("Card11", "Карта одиннадцатая", new Monsters(), Rarity.SILVER, 11, Roweble.MELLE));
        deckForPlayerOne.addCardInDeck(new Creature("Card12", "Карта двенадцатая", new Monsters(), Rarity.GOLD, 12, Roweble.RANGE));
        deckForPlayerOne.addCardInDeck(new Creature("Card13", "Карта тринадцатая", new Monsters(), Rarity.BRONZE, 13, Roweble.MELLE));
        deckForPlayerOne.addCardInDeck(new Creature("Card14", "Карта четырнадцатая", new Monsters(), Rarity.SILVER, 14, Roweble.SIEGE));
        deckForPlayerOne.addCardInDeck(new Creature("Card15", "Карта петнадцатая", new Monsters(), Rarity.GOLD, 15, Roweble.MELLE));
        deckForPlayerOne.addCardInDeck(new Creature("Card16", "Карта шестнадцатая", new Monsters(), Rarity.GOLD, 16, Roweble.RANGE));
        deckForPlayerOne.addCardInDeck(new Creature("Card17", "Карта семнадцатая", new Monsters(), Rarity.BRONZE, 17, Roweble.RANGE));
        deckForPlayerOne.addCardInDeck(new Creature("Card18", "Карта восемнадцатая", new Monsters(), Rarity.SILVER, 18, Roweble.MELLE));
        deckForPlayerOne.addCardInDeck(new Creature("Card19", "Карта девятнадцатая", new Monsters(), Rarity.GOLD, 19, Roweble.SIEGE));
        deckForPlayerOne.addCardInDeck(new Creature("Card20", "Карта двадцатая", new Monsters(), Rarity.BRONZE, 20, Roweble.MELLE));

        playerOne.setDeck(deckForPlayerOne);


        deckForPlayerTwo.addCardInDeck(new Creature("Card2", "Карта вторая", new Scoiatael(), Rarity.SILVER, 2, Roweble.RANGE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card1", "Карта первая", new Scoiatael(), Rarity.BRONZE, 1, Roweble.MELLE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card3", "Карта третья", new Scoiatael(), Rarity.GOLD, 3, Roweble.SIEGE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card4", "Карта четвертая", new Scoiatael(), Rarity.BRONZE, 4, Roweble.SIEGE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card5", "Карта пятая", new Scoiatael(), Rarity.SILVER, 5, Roweble.RANGE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card6", "Карта шестая", new Scoiatael(), Rarity.GOLD, 6, Roweble.MELLE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card7", "Карта седьмая", new Scoiatael(), Rarity.BRONZE, 7, Roweble.RANGE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card8", "Карта восьмая", new Scoiatael(), Rarity.SILVER, 8, Roweble.SIEGE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card9", "Карта девятая", new Scoiatael(), Rarity.GOLD, 9, Roweble.MELLE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card10", "Карта десятая", new Scoiatael(), Rarity.BRONZE, 10, Roweble.SIEGE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card11", "Карта одиннадцатая", new Scoiatael(), Rarity.SILVER, 11, Roweble.MELLE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card12", "Карта двенадцатая", new Scoiatael(), Rarity.GOLD, 12, Roweble.RANGE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card13", "Карта тринадцатая", new Scoiatael(), Rarity.BRONZE, 13, Roweble.MELLE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card14", "Карта четырнадцатая", new Scoiatael(), Rarity.SILVER, 14, Roweble.SIEGE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card15", "Карта петнадцатая", new Scoiatael(), Rarity.GOLD, 15, Roweble.MELLE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card16", "Карта шестнадцатая", new Scoiatael(), Rarity.GOLD, 16, Roweble.RANGE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card17", "Карта семнадцатая", new Scoiatael(), Rarity.BRONZE, 17, Roweble.RANGE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card18", "Карта восемнадцатая", new Scoiatael(), Rarity.SILVER, 18, Roweble.MELLE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card19", "Карта девятнадцатая", new Scoiatael(), Rarity.GOLD, 19, Roweble.SIEGE));
        deckForPlayerTwo.addCardInDeck(new Creature("Card20", "Карта двадцатая", new Scoiatael(), Rarity.BRONZE, 20, Roweble.MELLE));

        playerTwo.setDeck(deckForPlayerTwo);

        Battleground battleground = Battleground.getInstance();

        Game game = new Game(battleground, playerOne, playerTwo, new Round());

        game.game();

    }

}
