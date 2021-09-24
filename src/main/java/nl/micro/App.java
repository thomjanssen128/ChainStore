package nl.micro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    List<Card> cards = makeCards();


    public App() {
        while (true) {
            printOverview(cards);

            System.out.print("Enter the cardID: ");
            Scanner in = new Scanner(System.in);
            int cardId = in.nextInt();

            System.out.print("Enter the amount to pay: ");
            int amount = in.nextInt();
            makePayment(cardId, amount);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        App app = new App();

    }

    public List<Card> makeCards() {
        // aanmaken van cards
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new RegularCard("Abel", 123));
        cards.add(new GoldCard("Bente", 456, 4));
        cards.add(new GoldCard("Corneel", 8888, 30));
        cards.add(new RegularCard("Daphne", 0));
        cards.add(new RegularCard("Eveline", 1000000));
        cards.add(new GoldCard("Fons", -200, 12));

        return cards;
    }

    public void printOverview(List<Card> cards) {
        System.out.println("CardID   Name        Credit        Discount");
        for (Card c : cards) {
            System.out.println(c);
        }
        System.out.println();
    }

    public void makePayment(int cardId, double amount) {
        Card card = cards.get(cardId - 1);
        card.pay(amount);
    }

}
