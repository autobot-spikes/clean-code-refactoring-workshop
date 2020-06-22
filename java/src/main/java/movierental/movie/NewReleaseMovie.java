package movierental.movie;

import movierental.money.Money;

import java.time.Duration;

public class NewReleaseMovie extends Movie {

    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public Money getAmount(Duration rentalDuration) {
        return new Money(rentalDuration.toDays() * 3.0);
    }

    @Override
    public int getFrequentRenterPoints(Duration duration) {
        int rentalDurationPoints = duration.toDays() > 1 ? 1 : 0;
        return 1 + rentalDurationPoints;
    }
}
