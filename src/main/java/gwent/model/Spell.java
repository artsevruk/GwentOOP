package gwent.model;

import gwent.model.Fraction.Fraction;

/**
 * Created by artsevruk on 04.09.2017.
 */
public class Spell extends Card {


    private int numberRow;
    private int buf;

    public Spell(String name, String description, Fraction fraction, Rarity rarity, int numberRow, int buff) {
        super(name, description, fraction, rarity);
        this.numberRow = numberRow;
        this.buf = buff;
    }

    public int getNumberRow() {
        return numberRow;
    }

    public void setNumberRow(int numberRow) {
        if (numberRow <= 3 || numberRow > 0) {
            this.numberRow = numberRow;
        } else this.numberRow = 1;
    }

    public int getBuf() {
        return buf;
    }

    public void setBuf(int buf) {
        this.buf = buf;
    }
}
