package movierental.customer;

import movierental.builders.CustomerBuilder;
import movierental.money.Money;
import movierental.rental.*;
import movierental.movie.Movie;
import movierental.movie.NewReleaseMovie;
import movierental.movie.RegularMovie;
import org.junit.Test;

import java.time.Duration;
import java.util.Collections;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class CustomerTest {

    @Test
    public void testCustomer() {
        Customer c = new CustomerBuilder().build();

        assertNotNull(c);
    }

    @Test
    public void testRentals() {
        Customer customer = new CustomerBuilder().withName("Julia").build();
        Movie movie = new RegularMovie("Gone with the Wind");
        Rental rental = new Rental(movie, Duration.ofDays(3));

        customer.addRental(rental);

        assertEquals(Collections.singletonList(rental), customer.getRentals());
    }

    @Test
    public void testName() {
        Customer customer = new Customer("David");

        assertEquals("David", customer.getName());
    }

    @Test
    public void testTotalAmount() {
        Customer customer = new Customer("David");
        customer.addRental(new Rental(new NewReleaseMovie("Back to the Future"), Duration.ofDays(1)));
        customer.addRental(new Rental(new NewReleaseMovie("Back to the Future"), Duration.ofDays(2)));

        assertEquals(new Money(9.0), customer.getTotalAmount());
    }

    @Test
    public void testFrequentRenterPoints() {
        Customer customer = new Customer("David");
        customer.addRental(new Rental(new NewReleaseMovie("Back to the Future"), Duration.ofDays(1)));
        customer.addRental(new Rental(new NewReleaseMovie("Back to the Future"), Duration.ofDays(2)));

        assertEquals(3, customer.getFrequentRenterPoints());
    }
}
