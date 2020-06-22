package movierental.statement;

import movierental.customer.Customer;
import movierental.rental.*;
import movierental.movie.ChildrenMovie;
import movierental.movie.Movie;
import movierental.movie.NewReleaseMovie;
import movierental.movie.RegularMovie;
import org.junit.Test;

import java.io.IOException;
import java.time.Duration;

import static junit.framework.Assert.assertEquals;

public class TextStatementTest {

    @Test
    public void statementForRegularMovie() throws IOException {
        Movie movie1 = new RegularMovie("Gone with the Wind");
        Rental rental = new Rental(movie1, Duration.ofDays(3));
        Customer customer = new Customer("Sallie");
        customer.addRental(rental);
        String expected = "Rental Record for Sallie\n" +
                "\tGone with the Wind\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";

        String statement = new TextStatement(customer).format();

        assertEquals(expected, statement);
    }

    @Test
    public void statementForNewReleaseMovie() throws IOException {
        Movie movie1 = new NewReleaseMovie("Star Wars");
        Rental rental = new Rental(movie1, Duration.ofDays(3));
        Customer customer = new Customer("Sallie");
        customer.addRental(rental);
        String expected = "Rental Record for Sallie\n" +
                "\tStar Wars\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points";

        String statement = new TextStatement(customer).format();

        assertEquals(expected, statement);
    }

    @Test
    public void statementForChildrenMovie() throws IOException {
        Movie movie1 = new ChildrenMovie("Madagascar");
        Rental rental = new Rental(movie1, Duration.ofDays(3));
        Customer customer = new Customer("Sallie");
        customer.addRental(rental);
        String expected = "Rental Record for Sallie\n" +
                "\tMadagascar\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";

        String statement = new TextStatement(customer).format();

        assertEquals(expected, statement);
    }

    @Test
    public void statementForManyMovies() throws IOException {
        Movie movie1 = new ChildrenMovie("Madagascar");
        Rental rental1 = new Rental(movie1, Duration.ofDays(6));
        Movie movie2 = new NewReleaseMovie("Star Wars");
        Rental rental2 = new Rental(movie2, Duration.ofDays(2));
        Movie movie3 = new RegularMovie("Gone with the Wind");
        Rental rental3 = new Rental(movie3, Duration.ofDays(8));
        Customer customer = new Customer("David");
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);
        String expected = "Rental Record for David\n" +
                "\tMadagascar\t6.0\n" +
                "\tStar Wars\t6.0\n" +
                "\tGone with the Wind\t11.0\n" +
                "Amount owed is 23.0\n" +
                "You earned 4 frequent renter points";

        String statement = new TextStatement(customer).format();

        assertEquals(expected, statement);
    }
}
