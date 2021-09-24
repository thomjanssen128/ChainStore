package nl.micro;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoldCardTest {
    GoldCard c;

    @Before
    public void setUp() {
        c = new GoldCard("Gerritje", 1234);
    }

    @Test
    public void AfterPaymentCreditDecreases() {
        boolean payment = c.pay(234);
        assertEquals(1000, c.credit, 0);
    }

    @Test
    public void CreditsIsMoreThanPaymentPayReturnsTrue() {
        boolean payment = c.pay(234);
        assertEquals(true, payment);
    }

    @Test
    public void CreditsIsEqualThanPaymentPayReturnsTrue() {
        boolean payment = c.pay(1234);
        assertEquals(true, payment);
    }

    @Test
    public void WithGoldCardIfCreditsIsMoreThanPaymentPayReturnsTrue() {
        boolean payment = c.pay(1235);
        assertEquals(true, payment);
    }

    @Test(expected = ArgumentOutOfRangeException.class)
    public void negativeDiscountIsInvalid() {
        c.setDiscount(-1);
    }
    @Test(expected = ArgumentOutOfRangeException.class)
    public void discountsAbove30AreInvalid() {
        c.setDiscount(31);
    }
    @Test
    public void discountsBetween1And30AreValid() {
        c.setDiscount(4);
        assertEquals(4, c.discount);
    }

    @Test
    public void discountDecreasesTheAmountToPay(){
        c.setDiscount(10); //10%
        c.pay(1000); // 1000 * .9 = 900
        assertEquals(334, c.credit,0);
    }

    @Test
    public void createInstanceOfGoldCardWithDiscount(){
        GoldCard g = new GoldCard("Zalm", 300, 5);
        assertEquals(5, g.discount);
    }

    @Test
    public void cardGetUniqueIdNumbers() {
        GoldCard a = new GoldCard("a", 800);
        GoldCard b = new GoldCard("b", 1600);
        assertEquals(a.cardId+1, b.cardId);
    }
}