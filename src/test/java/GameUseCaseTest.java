import gwent.Card.*;
import gwent.Card.Fraction.Monsters;
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






    @Test
    public void testDeck()
    {







    }

    public static void main(String[] args) {
        Monsters monsters = new Monsters();

        Collection collection = new Collection();



        Game game = new Game();

        Deck deckForPlayerOne = new Deck("Deck for Player One");
        Deck deckForPlayerTwo = new Deck("Deck for Player Two");

        Player playerOne = new Player("PlayerOne", deckForPlayerOne);
        Player playerTwo = new Player("PlayerTwo", deckForPlayerTwo);


        Creature creature2 = new Creature("Card2", "Карта вторая", monsters, Rarity.SILVER, 3, Roweble.RANGE);
        Creature creature3 = new Creature("Card3", "Карта трейтья", monsters, Rarity.GOLD, 6, Roweble.SIEGE);
        Creature creature4 = new Creature("Card4", "Карта четвертая", monsters, Rarity.GOLD, 6, Roweble.SIEGE);
        Creature creature5 = new Creature("Card5", "Карта пятая", monsters, Rarity.GOLD, 6, Roweble.ANYROW);
        Spell spell1 = new Spell("Fireball", "-1 cardPower of card", monsters, Rarity.GOLD);
        Lord lordLeshiy = new Lord("Leshiy", "Лидер колодый, Леший", monsters, Rarity.GOLD, 7);


        deckForPlayerOne.addCardCreatureInDeck(new Creature("Card1", "Карта первая", monsters, Rarity.BRONZE, 5, Roweble.MELLE));
        deckForPlayerOne.addCardCreatureInDeck(creature2);
        deckForPlayerOne.addCardCreatureInDeck(creature3);
        deckForPlayerOne.addCardCreatureInDeck(creature4);
        deckForPlayerOne.addCardCreatureInDeck(creature5);
        deckForPlayerOne.addCardSpellInDeck(spell1);
        deckForPlayerOne.setLord(lordLeshiy);

        playerOne.setDeck(deckForPlayerOne);

        System.out.println("playerOne: " + playerOne);
        System.out.println("playerOne.getName(): " + playerOne.getName());
        System.out.println("playerOne.getDeck(): " + playerOne.getDeck());
        System.out.println("playerOne.card(): " + playerOne.getDeck().getCardsCreature().get(0).getCardPower());


    }



}
