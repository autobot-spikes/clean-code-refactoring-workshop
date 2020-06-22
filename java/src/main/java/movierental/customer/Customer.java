package movierental.customer;

import movierental.money.Money;
import movierental.rental.Rental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        this.rentals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public Money getTotalAmount() {
        return rentals.stream()
                .map(Rental::getAmount)
                .reduce(Money::add)
                .orElse(new Money(0.0));
    }

    public int getFrequentRenterPoints() {
        return rentals.stream()
                .mapToInt(rental -> rental.getMovie().getFrequentRenterPoints(rental.getDuration()))
                .sum();
    }
}
