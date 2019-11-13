package buildings.dwelling.hotel;

import buildings.dwelling.DwellingFloor;
import interfaces.Space;

import java.util.Objects;

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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(String.format("HotelFloor (%s, %s,",getCountSpaces(),getStar()));
        for (int i = 0; i < getCountSpaces() ; i++) {
            stringBuilder.append(getSpace(i).toString()+", ");
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof HotelFloor) return false;
        if (!super.equals(o)) return false;
        HotelFloor floor = (HotelFloor) o;
        return star == floor.star;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), star);
    }
}
