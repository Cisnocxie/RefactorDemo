package rentalstore;

public class RegularType implements MovieType {

    public double calAmount(int dayRented, double thisAmount) {
        thisAmount += 2;
        if(dayRented > 2){
            thisAmount+=(dayRented - 2) * 1.5;
        }
        return thisAmount;
    }
}
