package rentalstore;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer = new Customer("Jerry");

    @Test
    public void should_return_correct_statement_given_customer_has_no_rental() {
        String statement = customer.statement();
        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n" +
                "<P>You owe<EM>0.0</EM><P>\n" +
                "On this rental you earned <EM>0</EM> frequent renter points<P>", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_1_day() {
        Movie regularMovie = new Movie("Titanic", new RegularType());
        Rental oneDayRental = new Rental(regularMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        System.out.println(statement);

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n" +
                "Titanic: 2.0<BR>\n" +
                "<P>You owe<EM>2.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_3_day() {
        Movie regularMovie = new Movie("Titanic", new RegularType());
        Rental threeDayRental = new Rental(regularMovie, 3);
        customer.addRental(threeDayRental);

        String statement = customer.statement();

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n" +
                "Titanic: 3.5<BR>\n" +
                "<P>You owe<EM>3.5</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_1_day() {
        Movie newReleaseMovie = new Movie("Titanic", new NewReleaseType());
        Rental oneDayRental = new Rental(newReleaseMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n" +
                        newReleaseMovie.getTitle() + ": 3.0<BR>\n" +
                        "<P>You owe<EM>3.0</EM><P>\n" +
                        "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_2_day() {
        Movie newReleaseMovie = new Movie("Titanic", new NewReleaseType());
        Rental twoDayRental = new Rental(newReleaseMovie, 2);
        customer.addRental(twoDayRental);

        String statement = customer.statement();

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n" +
                        newReleaseMovie.getTitle() + ": 6.0<BR>\n" +
                        "<P>You owe<EM>6.0</EM><P>\n" +
                        "On this rental you earned <EM>2</EM> frequent renter points<P>", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_1_day() {
        Movie childrenMovie = new Movie("Titanic", new ChildrensType());
        Rental oneDayRental = new Rental(childrenMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n" +
                        childrenMovie.getTitle() + ": 1.5<BR>\n" +
                        "<P>You owe<EM>1.5</EM><P>\n" +
                        "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        Movie childrenMovie = new Movie("Titanic", new ChildrensType());
        Rental fourDayRental = new Rental(childrenMovie, 4);
        customer.addRental(fourDayRental);

        String statement = customer.statement();

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n" +
                        childrenMovie.getTitle() + ": 3.0<BR>\n" +
                        "<P>You owe<EM>3.0</EM><P>\n" +
                        "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }

}
