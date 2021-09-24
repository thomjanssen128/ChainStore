package nl.micro;

public class RegularCard extends Card{

    public RegularCard(String name, double credit) {
        super(name, credit);
    }

    @Override
    public boolean pay(double amount) {
        if (credit - amount < 0) {
            return false;
        }
        credit -= amount;
        return true;
    }
}
