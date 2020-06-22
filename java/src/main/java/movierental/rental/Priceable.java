package movierental.rental;

import movierental.money.Money;

import java.time.Duration;

public interface Priceable {
    Money getAmount(Duration rentalDuration);
}
