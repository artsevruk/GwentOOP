package util;

import gwent.model.Creature;
import gwent.model.Fraction.*;
import gwent.model.Rarity;
import gwent.model.Roweble;
import org.testng.annotations.DataProvider;

/**
 * Created by artsevruk on 11.09.2017.
 */
public class MonstersGlobalDataProvider {


    @DataProvider(name = "Monsters")
    public static Object[][] monsters() {
        return new Object[][]{new Object[]
                {new Creature("Card1", "Карта первая", new Monsters(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card2", "Карта вторая", new Monsters(), Rarity.BRONZE, 2, Roweble.RANGE)},
                {new Creature("Card3", "Карта третья", new Monsters(), Rarity.BRONZE, 3, Roweble.SIEGE)},
                {new Creature("Card4", "Карта четвертая", new Monsters(), Rarity.BRONZE, 4, Roweble.SIEGE)},
                {new Creature("Card5", "Карта пятая", new Monsters(), Rarity.SILVER, 5, Roweble.RANGE)},
                {new Creature("Card6", "Карта шестая", new Monsters(), Rarity.BRONZE, 6, Roweble.MELLE)},
                {new Creature("Card7", "Карта седьмая", new Monsters(), Rarity.BRONZE, 7, Roweble.RANGE)},
                {new Creature("Card8", "Карта восьмая", new Monsters(), Rarity.SILVER, 8, Roweble.SIEGE)},
                {new Creature("Card9", "Карта девятая", new Monsters(), Rarity.BRONZE, 9, Roweble.MELLE)},
                {new Creature("Card10", "Карта десятая", new Monsters(), Rarity.BRONZE, 10, Roweble.SIEGE)},
                {new Creature("Card11", "Карта одиннадцатая", new Monsters(), Rarity.SILVER, 11, Roweble.MELLE)},
                {new Creature("Card12", "Карта двенадцатая", new Monsters(), Rarity.GOLD, 12, Roweble.RANGE)},
                {new Creature("Card13", "Карта тринадцатая", new Monsters(), Rarity.BRONZE, 13, Roweble.MELLE)},
                {new Creature("Card14", "Карта четырнадцатая", new Monsters(), Rarity.SILVER, 14, Roweble.SIEGE)},
                {new Creature("Card15", "Карта петнадцатая", new Monsters(), Rarity.BRONZE, 15, Roweble.MELLE)},
                {new Creature("Card16", "Карта шестнадцатая", new Monsters(), Rarity.SILVER, 16, Roweble.RANGE)},
                {new Creature("Card17", "Карта семнадцатая", new Monsters(), Rarity.SILVER, 17, Roweble.RANGE)},
                {new Creature("Card18", "Карта восемнадцатая", new Monsters(), Rarity.GOLD, 18, Roweble.MELLE)},
                {new Creature("Card19", "Карта девятнадцатая", new Monsters(), Rarity.GOLD, 19, Roweble.SIEGE)},
                {new Creature("Card20", "Карта двадцатая", new Monsters(), Rarity.GOLD, 20, Roweble.MELLE)},
                {new Creature("Card1", "Карта первая", new Scoiatael(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card2", "Карта вторая", new Scoiatael(), Rarity.BRONZE, 2, Roweble.RANGE)},
                {new Creature("Card3", "Карта третья", new Scoiatael(), Rarity.BRONZE, 3, Roweble.SIEGE)},
                {new Creature("Card4", "Карта четвертая", new Scoiatael(), Rarity.BRONZE, 4, Roweble.SIEGE)},
                {new Creature("Card5", "Карта пятая", new Scoiatael(), Rarity.SILVER, 5, Roweble.RANGE)},
                {new Creature("Card6", "Карта шестая", new Scoiatael(), Rarity.BRONZE, 6, Roweble.MELLE)},
                {new Creature("Card7", "Карта седьмая", new Scoiatael(), Rarity.BRONZE, 7, Roweble.RANGE)},
                {new Creature("Card8", "Карта восьмая", new Scoiatael(), Rarity.SILVER, 8, Roweble.SIEGE)},
                {new Creature("Card9", "Карта девятая", new Scoiatael(), Rarity.BRONZE, 9, Roweble.MELLE)},
                {new Creature("Card10", "Карта десятая", new Scoiatael(), Rarity.BRONZE, 10, Roweble.SIEGE)},
                {new Creature("Card11", "Карта одиннадцатая", new Scoiatael(), Rarity.SILVER, 11, Roweble.MELLE)},
                {new Creature("Card12", "Карта двенадцатая", new Scoiatael(), Rarity.GOLD, 12, Roweble.RANGE)},
                {new Creature("Card13", "Карта тринадцатая", new Scoiatael(), Rarity.BRONZE, 13, Roweble.MELLE)},
                {new Creature("Card14", "Карта четырнадцатая", new Scoiatael(), Rarity.SILVER, 14, Roweble.SIEGE)},
                {new Creature("Card15", "Карта петнадцатая", new Scoiatael(), Rarity.BRONZE, 15, Roweble.MELLE)},
                {new Creature("Card16", "Карта шестнадцатая", new Scoiatael(), Rarity.SILVER, 16, Roweble.RANGE)},
                {new Creature("Card17", "Карта семнадцатая", new Scoiatael(), Rarity.SILVER, 17, Roweble.RANGE)},
                {new Creature("Card18", "Карта восемнадцатая", new Scoiatael(), Rarity.GOLD, 18, Roweble.MELLE)},
                {new Creature("Card19", "Карта девятнадцатая", new Scoiatael(), Rarity.GOLD, 19, Roweble.SIEGE)},
                {new Creature("Card20", "Карта двадцатая", new Scoiatael(), Rarity.GOLD, 20, Roweble.MELLE)},
                {new Creature("Card1", "Карта первая", new NorthernRealm(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card2", "Карта вторая", new NorthernRealm(), Rarity.BRONZE, 2, Roweble.RANGE)},
                {new Creature("Card3", "Карта третья", new NorthernRealm(), Rarity.BRONZE, 3, Roweble.SIEGE)},
                {new Creature("Card4", "Карта четвертая", new NorthernRealm(), Rarity.BRONZE, 4, Roweble.SIEGE)},
                {new Creature("Card5", "Карта пятая", new NorthernRealm(), Rarity.SILVER, 5, Roweble.RANGE)},
                {new Creature("Card6", "Карта шестая", new NorthernRealm(), Rarity.BRONZE, 6, Roweble.MELLE)},
                {new Creature("Card7", "Карта седьмая", new NorthernRealm(), Rarity.BRONZE, 7, Roweble.RANGE)},
                {new Creature("Card8", "Карта восьмая", new NorthernRealm(), Rarity.SILVER, 8, Roweble.SIEGE)},
                {new Creature("Card9", "Карта девятая", new NorthernRealm(), Rarity.BRONZE, 9, Roweble.MELLE)},
                {new Creature("Card10", "Карта десятая", new NorthernRealm(), Rarity.BRONZE, 10, Roweble.SIEGE)},
                {new Creature("Card11", "Карта одиннадцатая", new NorthernRealm(), Rarity.SILVER, 11, Roweble.MELLE)},
                {new Creature("Card12", "Карта двенадцатая", new NorthernRealm(), Rarity.GOLD, 12, Roweble.RANGE)},
                {new Creature("Card13", "Карта тринадцатая", new NorthernRealm(), Rarity.BRONZE, 13, Roweble.MELLE)},
                {new Creature("Card14", "Карта четырнадцатая", new NorthernRealm(), Rarity.SILVER, 14, Roweble.SIEGE)},
                {new Creature("Card15", "Карта петнадцатая", new NorthernRealm(), Rarity.BRONZE, 15, Roweble.MELLE)},
                {new Creature("Card16", "Карта шестнадцатая", new NorthernRealm(), Rarity.SILVER, 16, Roweble.RANGE)},
                {new Creature("Card17", "Карта семнадцатая", new NorthernRealm(), Rarity.SILVER, 17, Roweble.RANGE)},
                {new Creature("Card18", "Карта восемнадцатая", new NorthernRealm(), Rarity.GOLD, 18, Roweble.MELLE)},
                {new Creature("Card19", "Карта девятнадцатая", new NorthernRealm(), Rarity.GOLD, 19, Roweble.SIEGE)},
                {new Creature("Card20", "Карта двадцатая", new NorthernRealm(), Rarity.GOLD, 20, Roweble.MELLE)},
                {new Creature("Card1", "Карта первая", new Skellige(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card2", "Карта вторая", new Skellige(), Rarity.BRONZE, 2, Roweble.RANGE)},
                {new Creature("Card3", "Карта третья", new Skellige(), Rarity.BRONZE, 3, Roweble.SIEGE)},
                {new Creature("Card4", "Карта четвертая", new Skellige(), Rarity.BRONZE, 4, Roweble.SIEGE)},
                {new Creature("Card5", "Карта пятая", new Skellige(), Rarity.SILVER, 5, Roweble.RANGE)},
                {new Creature("Card6", "Карта шестая", new Skellige(), Rarity.BRONZE, 6, Roweble.MELLE)},
                {new Creature("Card7", "Карта седьмая", new Skellige(), Rarity.BRONZE, 7, Roweble.RANGE)},
                {new Creature("Card8", "Карта восьмая", new Skellige(), Rarity.SILVER, 8, Roweble.SIEGE)},
                {new Creature("Card9", "Карта девятая", new Skellige(), Rarity.BRONZE, 9, Roweble.MELLE)},
                {new Creature("Card10", "Карта десятая", new Skellige(), Rarity.BRONZE, 10, Roweble.SIEGE)},
                {new Creature("Card11", "Карта одиннадцатая", new Skellige(), Rarity.SILVER, 11, Roweble.MELLE)},
                {new Creature("Card12", "Карта двенадцатая", new Skellige(), Rarity.GOLD, 12, Roweble.RANGE)},
                {new Creature("Card13", "Карта тринадцатая", new Skellige(), Rarity.BRONZE, 13, Roweble.MELLE)},
                {new Creature("Card14", "Карта четырнадцатая", new Skellige(), Rarity.SILVER, 14, Roweble.SIEGE)},
                {new Creature("Card15", "Карта петнадцатая", new Skellige(), Rarity.BRONZE, 15, Roweble.MELLE)},
                {new Creature("Card16", "Карта шестнадцатая", new Skellige(), Rarity.SILVER, 16, Roweble.RANGE)},
                {new Creature("Card17", "Карта семнадцатая", new Skellige(), Rarity.SILVER, 17, Roweble.RANGE)},
                {new Creature("Card18", "Карта восемнадцатая", new Skellige(), Rarity.GOLD, 18, Roweble.MELLE)},
                {new Creature("Card19", "Карта девятнадцатая", new Skellige(), Rarity.GOLD, 19, Roweble.SIEGE)},
                {new Creature("Card20", "Карта двадцатая", new Skellige(), Rarity.GOLD, 20, Roweble.MELLE)},
                {new Creature("Card1", "Карта первая", new Neutral(), Rarity.BRONZE, 1, Roweble.MELLE)},
                {new Creature("Card2", "Карта вторая", new Neutral(), Rarity.BRONZE, 2, Roweble.RANGE)},
                {new Creature("Card3", "Карта третья", new Neutral(), Rarity.BRONZE, 3, Roweble.SIEGE)},
                {new Creature("Card4", "Карта четвертая", new Neutral(), Rarity.BRONZE, 4, Roweble.SIEGE)},
                {new Creature("Card5", "Карта пятая", new Neutral(), Rarity.SILVER, 5, Roweble.RANGE)},
                {new Creature("Card6", "Карта шестая", new Neutral(), Rarity.BRONZE, 6, Roweble.MELLE)},
                {new Creature("Card7", "Карта седьмая", new Neutral(), Rarity.BRONZE, 7, Roweble.RANGE)},
                {new Creature("Card8", "Карта восьмая", new Neutral(), Rarity.SILVER, 8, Roweble.SIEGE)},
                {new Creature("Card9", "Карта девятая", new Neutral(), Rarity.BRONZE, 9, Roweble.MELLE)},
                {new Creature("Card10", "Карта десятая", new Neutral(), Rarity.BRONZE, 10, Roweble.SIEGE)},
                {new Creature("Card11", "Карта одиннадцатая", new Neutral(), Rarity.SILVER, 11, Roweble.MELLE)},
                {new Creature("Card12", "Карта двенадцатая", new Neutral(), Rarity.GOLD, 12, Roweble.RANGE)},
                {new Creature("Card13", "Карта тринадцатая", new Neutral(), Rarity.BRONZE, 13, Roweble.MELLE)},
                {new Creature("Card14", "Карта четырнадцатая", new Neutral(), Rarity.SILVER, 14, Roweble.SIEGE)},
                {new Creature("Card15", "Карта петнадцатая", new Neutral(), Rarity.BRONZE, 15, Roweble.MELLE)},
                {new Creature("Card16", "Карта шестнадцатая", new Neutral(), Rarity.SILVER, 16, Roweble.RANGE)},
                {new Creature("Card17", "Карта семнадцатая", new Neutral(), Rarity.SILVER, 17, Roweble.RANGE)},
                {new Creature("Card18", "Карта восемнадцатая", new Neutral(), Rarity.GOLD, 18, Roweble.MELLE)},
                {new Creature("Card19", "Карта девятнадцатая", new Neutral(), Rarity.GOLD, 19, Roweble.SIEGE)},
                {new Creature("Card20", "Карта двадцатая", new Neutral(), Rarity.GOLD, 20, Roweble.MELLE)},
                };
        }
}