package gwent.Card.Fraction;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Monsters extends Fraction{

    public Monsters()
    {
        super("Monsters");
    }

    public static void main(String[] args) {
        Monsters monsters = new Monsters();
        System.out.println(monsters.name);
    }
}
