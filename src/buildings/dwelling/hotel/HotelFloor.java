package buildings.dwelling.hotel;

import buildings.dwelling.DwellingFloor;
import interfaces.Space;

public class HotelFloor extends DwellingFloor {
    private double star;
    private static final double constStar = 1;

    public HotelFloor(int count){
        super(count);
        star = constStar;

    }

    public HotelFloor(Space[] spaces){
        super(spaces);
        star = constStar;
    }


    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }
}
