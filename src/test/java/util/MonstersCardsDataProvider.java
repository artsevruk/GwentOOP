package util;

import gwent.model.Creature;
import gwent.model.Fraction.*;
import gwent.model.Rarity;
import gwent.model.Roweble;
import org.testng.annotations.DataProvider;

/**
 * Created by artsevruk on 11.09.2017.
 */
public class MonstersCardsDataProvider {


    @DataProvider(name = "CustomMonsters")
    public static Object[][] monsters() {
        return new Object[][]{
                {new Creature("Card1", "Карта первая", new Monsters(), Rarity.BRONZE, 1, Roweble.MELLE), new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card2", "Карта вторая", new Monsters(), Rarity.BRONZE, 2, Roweble.RANGE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card3", "Карта третья", new Monsters(), Rarity.BRONZE, 3, Roweble.SIEGE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card4", "Карта четвертая", new Monsters(), Rarity.BRONZE, 4, Roweble.SIEGE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card5", "Карта пятая", new Monsters(), Rarity.SILVER, 5, Roweble.RANGE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card6", "Карта шестая", new Monsters(), Rarity.BRONZE, 6, Roweble.MELLE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card7", "Карта седьмая", new Monsters(), Rarity.BRONZE, 7, Roweble.RANGE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card8", "Карта восьмая", new Monsters(), Rarity.SILVER, 8, Roweble.SIEGE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card9", "Карта девятая", new Monsters(), Rarity.BRONZE, 9, Roweble.MELLE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card10", "Карта десятая", new Monsters(), Rarity.BRONZE, 10, Roweble.SIEGE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card11", "Карта одиннадцатая", new Monsters(), Rarity.SILVER, 11, Roweble.MELLE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card12", "Карта двенадцатая", new Monsters(), Rarity.GOLD, 12, Roweble.RANGE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card13", "Карта тринадцатая", new Monsters(), Rarity.BRONZE, 13, Roweble.MELLE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card14", "Карта четырнадцатая", new Monsters(), Rarity.SILVER, 14, Roweble.SIEGE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card15", "Карта петнадцатая", new Monsters(), Rarity.BRONZE, 15, Roweble.MELLE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card16", "Карта шестнадцатая", new Monsters(), Rarity.SILVER, 16, Roweble.RANGE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card17", "Карта семнадцатая", new Monsters(), Rarity.SILVER, 17, Roweble.RANGE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card18", "Карта восемнадцатая", new Monsters(), Rarity.GOLD, 18, Roweble.MELLE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card19", "Карта девятнадцатая", new Monsters(), Rarity.GOLD, 19, Roweble.SIEGE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card20", "Карта двадцатая", new Monsters(), Rarity.GOLD, 20, Roweble.MELLE),new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},

        };
    }
}
