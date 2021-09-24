package nl.micro;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegularCardTest {
    Card c;
    @Before
        public void setUp() {
        c = new RegularCard("Gerritje", 1234);
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
    public void WithRegularCardIfCreditsIsmoreThanPaymentPayReturnsFalse() {
        boolean payment = c.pay(1235);
        assertEquals(false, payment);
    }
}


