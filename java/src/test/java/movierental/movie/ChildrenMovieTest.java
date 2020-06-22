package movierental.movie;

import movierental.money.Money;
import org.junit.Test;

import java.time.Duration;

import static junit.framework.Assert.assertEquals;

public class ChildrenMovieTest {

    @Test
    public void testAmountRentedForOneDay() {
        Movie movie = new ChildrenMovie("Frozen");

        assertEquals(new Money(1.5), movie.getAmount(Duration.ofDays(1)));
    }

    @Test
    public void testAmountRentedForFiveDays() {
        Movie movie = new ChildrenMovie("Frozen");

        assertEquals(new Money(4.5), movie.getAmount(Duration.ofDays(5)));
    }

    @Test
    public void testFrequentRenterAmountRentedForTwoDays() {
        Movie movie = new ChildrenMovie("Frozen");

        assertEquals(1, movie.getFrequentRenterPoints(Duration.ofDays(2)));
    }
}
