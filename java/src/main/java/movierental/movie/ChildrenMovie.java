package movierental.movie;

import movierental.money.Money;

import java.time.Duration;

public class ChildrenMovie extends Movie {

    public static final Duration OVERDUE = Duration.ofDays(3);

    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public Money getAmount(Duration rentalDuration) {
        long overdue = Math.max(0, (rentalDuration.minus(OVERDUE)).toDays());
        return new Money(1.5 + overdue * 1.5);
    }
}
