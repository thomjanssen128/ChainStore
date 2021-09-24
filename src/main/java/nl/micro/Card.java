package nl.micro;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

public abstract class Card {
    static int nextCardId = 0;
    public int cardId;
    String name;
    double credit;

    public Card() {
    }

    public Card(String name, double credit) {
        this.cardId = ++nextCardId;
        this.name = name;
        this.credit = credit;
    }

    // public Card getCardById(int cardId) {
    //
    // }

    abstract boolean pay(double amount);

    @Override
    public String toString() {
        //             System.out.print(" ".repeat(8 - card.getName().length()));
        return "  " + cardId + " ".repeat(6) + name + " ".repeat(12 - name.length())  + credit;
    }
}
