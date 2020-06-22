package movierental.movie;

import movierental.rental.FrequentRenterPointCollectible;
import movierental.rental.Priceable;

import java.time.Duration;

public abstract class Movie implements Priceable, FrequentRenterPointCollectible {

    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int getFrequentRenterPoints(Duration duration) {
        return 1;
    }
}
