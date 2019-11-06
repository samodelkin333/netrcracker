package buildings.dwelling.hotel;

import buildings.dwelling.DwellingFloor;
import interfaces.Space;

public class HotelFloor extends DwellingFloor {
    private double coeff;
    private static final double constCoeff = 1;


    public HotelFloor(int count){
        super(count);
        coeff = constCoeff;

    }

    public HotelFloor(Space[] spaces){
        super(spaces);
        coeff= constCoeff;
    }


    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }
}
