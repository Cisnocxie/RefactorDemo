package rentalstore;

public class NewReleaseType implements MovieType {

    public double calAmount(int dayRented, double thisAmount) {
        thisAmount += dayRented*3;
        return thisAmount;
    }
}
