package gwent.model.Fraction;


import gwent.Id;

/**
 * Created by artsevruk on 04.09.2017.
 */
public abstract class Fraction extends Id {

    protected String name = "Fraction";


    public Fraction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name;}
}
