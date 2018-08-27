package rentalstore;

public class ChildrensType implements MovieType {

    public double calAmount(int dayRented, double thisAmount) {
        thisAmount+=1.5;
        if(dayRented > 3){
            thisAmount += (dayRented - 3)*1.5;
        }
        return thisAmount;
    }
}
