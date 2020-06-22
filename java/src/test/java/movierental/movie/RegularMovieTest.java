package movierental.movie;

import movierental.money.Money;
import org.junit.Test;

import java.time.Duration;

import static junit.framework.Assert.assertEquals;

public class RegularMovieTest {

    @Test
    public void testAmountRentedForOneDay() {
        Movie movie = new RegularMovie("Memento");

        assertEquals(new Money(2.0), movie.getAmount(Duration.ofDays(1)));
    }

    @Test
    public void testAmountRentedForFiveDays() {
        Movie movie = new RegularMovie("Memento");

        assertEquals(new Money(6.5), movie.getAmount(Duration.ofDays(5)));
    }

    @Test
    public void testFrequentRenterAmountRentedForTwoDays() {
        Movie movie = new RegularMovie("Memento");

        assertEquals(1, movie.getFrequentRenterPoints(Duration.ofDays(2)));
    }
}
