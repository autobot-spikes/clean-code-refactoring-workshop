package movierental.money;

import org.junit.Assert;
import org.junit.Test;

public class MoneyTest {

    @Test
    public void testAdd() {
        Money money = new Money(100.00);

        money.add(new Money(0.01));

        Assert.assertEquals(new Money(100.01), money);
    }
}
