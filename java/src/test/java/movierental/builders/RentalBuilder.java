package movierental.builders;

import movierental.movie.Movie;
import movierental.movie.RegularMovie;
import movierental.rental.Rental;

import java.time.Duration;

public class RentalBuilder {

    private static final Movie MOVIE = new RegularMovie("Memento");
    private static final Duration DURATION = Duration.ofDays(1);

    private Movie movie = MOVIE;
    private Duration duration = DURATION;

    public Rental build() {
        return new Rental(movie, duration);
    }

    public RentalBuilder withMovie(Movie movie) {
        this.movie = movie;
        return this;
    }

    public RentalBuilder withDuration(Duration duration) {
        this.duration = duration;
        return this;
    }
}
