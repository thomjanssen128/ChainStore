package nl.micro;

public class GoldCard extends Card {

    int discount;

    public GoldCard(String name, double credit) {
        super(name, credit);
    }

    public GoldCard(String name, double credit, int discount){
        super(name, credit);
        setDiscount(discount);
    }



    public void setDiscount(int discount) {
        if (discount >= 1 && discount <= 30) {
            this.discount = discount;
        } else throw new ArgumentOutOfRangeException("This is an invalid discount" + discount);
    }


    @Override
    public boolean pay(double amount) {
        credit -= (amount * (1 - (discount / 100.0)));
        return true;
    }

    @Override
    public String toString() {
        return "  " + cardId + " ".repeat(6) + name + " ".repeat(12 - name.length() ) + credit + " ".repeat(14 - (String.valueOf(credit).length())>1?String.valueOf(credit).length():2) + discount;
    }
}
