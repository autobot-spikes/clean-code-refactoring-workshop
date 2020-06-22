package movierental.movie;

import movierental.money.Money;
import org.junit.Test;

import java.time.Duration;

import static junit.framework.Assert.assertEquals;

public class NewReleaseMovieTest {

    @Test
    public void testAmountRentedForOneDay() {
        Movie movie = new NewReleaseMovie("Back to the Future");

        assertEquals(new Money(3.0), movie.getAmount(Duration.ofDays(1)));
    }

    @Test
    public void testAmountRentedForFiveDays() {
        Movie movie = new NewReleaseMovie("Back to the Future");

        assertEquals(new Money(15.0), movie.getAmount(Duration.ofDays(5)));
    }

    @Test
    public void testFrequentRenterAmountRentedForOneDay() {
        Movie movie = new NewReleaseMovie("Back to the Future");

        assertEquals(1, movie.getFrequentRenterPoints(Duration.ofDays(1)));
    }

    @Test
    public void testFrequentRenterAmountRentedForTwoDays() {
        Movie movie = new NewReleaseMovie("Back to the Future");

        assertEquals(2, movie.getFrequentRenterPoints(Duration.ofDays(2)));
    }
}
