package movierental.statement;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;
import movierental.customer.Customer;

import java.io.IOException;
import java.util.Collections;

import static com.google.common.io.Resources.getResource;

public class TextStatement implements Statement {

    private Customer customer;
    private Jinjava jinjava;
    private String template;

    public TextStatement(Customer customer) throws IOException {
        this.customer = customer;
        this.jinjava = new Jinjava();
        this.template = loadTemplate();
    }

    @SuppressWarnings("UnstableApiUsage")
    private String loadTemplate() throws IOException {
        return Resources.toString(getResource(this.getClass(), "statement.txt"), Charsets.UTF_8);
    }

    @Override
    public String format() {
        return jinjava.render(template, Collections.singletonMap("customer", customer));
    }
}
