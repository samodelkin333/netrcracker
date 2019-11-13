package buildings.dwelling.hotel;

import buildings.dwelling.DwellingFloor;
import interfaces.Space;

public class HotelFloor extends DwellingFloor {
    private int star;
    private static final int constStar = 1;

    public HotelFloor(int count){
        super(count);
        star = constStar;

    }

    public HotelFloor(Space[] spaces){
        super(spaces);
        star = constStar;
    }


    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
