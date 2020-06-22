package movierental.rental;

import movierental.money.Money;
import movierental.movie.Movie;

import java.time.Duration;

public class Rental {

    private Movie movie;
    private Duration duration;

    public Rental(Movie movie, Duration duration) {
        this.movie = movie;
        this.duration = duration;
    }

    public Movie getMovie() {
        return movie;
    }

    public Duration getDuration() {
        return duration;
    }

    public Money getAmount() {
        return movie.getAmount(duration);
    }
}
