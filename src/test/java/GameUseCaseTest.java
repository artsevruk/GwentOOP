import gwent.Card.*;
import gwent.Card.Fraction.Monsters;
import gwent.Game.Battleground;
import gwent.Game.Game;
import gwent.Game.Player;
import gwent.Game.Round;
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
        Round round = new Round();


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
        Creature creature6 = new Creature("Card6", "Карта шестая", monsters, Rarity.GOLD, 6, Roweble.ANYROW);
        Creature creature7 = new Creature("Card7", "Карта седьмая", monsters, Rarity.GOLD, 6, Roweble.ANYROW);
        Spell spell = new Spell("Fireball1", "-1 cardPower of card", monsters, Rarity.GOLD);
        Spell spell2 = new Spell("Fireball2", "-1 cardPower of card", monsters, Rarity.SILVER);
        Spell spell3 = new Spell("Fireball3", "-1 cardPower of card", monsters, Rarity.GOLD);
        Spell spell4 = new Spell("Fireball4", "-1 cardPower of card", monsters, Rarity.BRONZE);
        Spell spell5 = new Spell("Fireball5", "-1 cardPower of card", monsters, Rarity.BRONZE);
        Spell spell6 = new Spell("Fireball6", "-1 cardPower of card", monsters, Rarity.BRONZE);
        Spell spell7 = new Spell("Fireball7", "-1 cardPower of card", monsters, Rarity.BRONZE);
        Lord lordLeshiy = new Lord("Leshiy", "Лидер колодый, Леший", monsters, Rarity.GOLD, 7);


        deckForPlayerOne.addCardInDeck(new Creature("Card1", "Карта первая", monsters, Rarity.BRONZE, 5, Roweble.MELLE));
        deckForPlayerOne.addCardInDeck(creature2);
        deckForPlayerOne.addCardInDeck(creature3);
        deckForPlayerOne.addCardInDeck(creature4);
        deckForPlayerOne.addCardInDeck(creature5);
        deckForPlayerOne.addCardInDeck(creature6);
        deckForPlayerOne.addCardInDeck(creature7);
        deckForPlayerOne.addCardInDeck(spell);
        deckForPlayerOne.addCardInDeck(spell2);
        deckForPlayerOne.addCardInDeck(spell3);
        deckForPlayerOne.addCardInDeck(spell4);
        deckForPlayerOne.addCardInDeck(spell5);
        deckForPlayerOne.addCardInDeck(spell6);
        deckForPlayerOne.addCardInDeck(spell7);
        deckForPlayerOne.setLord(lordLeshiy);

        playerOne.setDeck(deckForPlayerOne);




        System.out.println("round: " + round.getRound());


        System.out.println("1: " + playerOne.getDeck().getCards().size());
        System.out.println("2: " + playerOne.getCardsOnHand().size());

        game.drawCardsOnHand(playerOne,round);

        System.out.println("3: " + playerOne.getDeck().getCards().size());
        System.out.println("4: " + playerOne.getCardsOnHand().size());

        round.setRound(2);
        game.drawCardsOnHand(playerOne,round);

        System.out.println("5: " + playerOne.getDeck().getCards().size());
        System.out.println("6: " + playerOne.getCardsOnHand().size());

        round.setRound(3);
        game.drawCardsOnHand(playerOne,round);

        System.out.println("7: " + playerOne.getDeck().getCards().size());
        System.out.println("8: " + playerOne.getCardsOnHand().size());


        System.out.println("cardInHand: " + playerOne.getCardsOnHand().get(0).getName());
        System.out.println("cardInHand: " + playerOne.getCardsOnHand().get(1).getName());
        System.out.println("cardInHand: " + playerOne.getCardsOnHand().get(2).getName());
        System.out.println("cardInHand: " + playerOne.getCardsOnHand().get(3).getName());
        System.out.println("cardInHand: " + playerOne.getCardsOnHand().get(4).getName());
        System.out.println("cardInHand: " + playerOne.getCardsOnHand().get(5).getName());
        System.out.println("cardInHand: " + playerOne.getCardsOnHand().get(6).getName());
        System.out.println("cardInHand: " + playerOne.getCardsOnHand().get(7).getName());
        System.out.println("cardInHand: " + playerOne.getCardsOnHand().get(8).getName());
        System.out.println("cardInHand: " + playerOne.getCardsOnHand().get(9).getName());
        System.out.println("cardInHand: " + playerOne.getCardsOnHand().get(10).getName());
        System.out.println("cardInHand: " + playerOne.getCardsOnHand().get(11).getName());
        System.out.println("cardInHand: " + playerOne.getCardsOnHand().get(12).getName());


        System.out.println("CardPower: " + Battleground.getInstance().getCardPowerOnRowInEndRound(playerOne.getCardsOnHand()));

    }
}
