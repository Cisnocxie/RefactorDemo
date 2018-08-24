package rentalstore;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer = new Customer("Jerry");

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        Movie regularMovie = new Movie("Titanic", 0);
        Rental oneDayRental = new Rental(regularMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        System.out.println(statement);

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n" +
                "Titanic: 3.0<BR>\n" +
                "<P>You owe<EM>3.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }
}
