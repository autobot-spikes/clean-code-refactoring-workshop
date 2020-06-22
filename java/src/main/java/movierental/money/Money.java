package movierental.money;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Money {

    private double value;

    public Money(double value) {
        this.value = value;
    }

    public Money add(Money money) {
        value += money.value;
        return this;
    }

    public String toString() {
        return String.valueOf(value);
    }
}
