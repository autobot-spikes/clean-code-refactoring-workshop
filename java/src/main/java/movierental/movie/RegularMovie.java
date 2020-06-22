package movierental.movie;

import movierental.money.Money;

import java.time.Duration;

public class RegularMovie extends Movie {

    public static final Duration OVERDUE = Duration.ofDays(2);

    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public Money getAmount(Duration rentalDuration) {
        long overdue = Math.max(0, (rentalDuration.minus(OVERDUE)).toDays());
        return new Money(2.0 + overdue * 1.5);
    }
}
