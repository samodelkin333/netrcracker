package buildings.dwelling.hotel;

import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;
import interfaces.Floor;
import interfaces.Space;

public class Hotel extends Dwelling {

    public Hotel(int countFloors, int[] countSpaces){
        super(countFloors,countSpaces);

    }

    public Hotel(Floor[] floors){
        super(floors);
    }

    public double getMaxCoeff(){
        Floor[] floors = getFloors();
        double countStar=0;
        for (int i = 0; i < floors.length; i++) {
            if (floors[i] instanceof HotelFloor) {
                HotelFloor floor = (HotelFloor) floors[i];
                countStar+= floor.getStar();
            }
        }
        return countStar;
    }


    public Space getBestSpace(){
        Floor[] floors = getFloors();
        double maxCoeff=0;
        Space bestSpace = null;
        for (int i = 0; i < floors.length ; i++) {
            if (floors[i] instanceof HotelFloor){
                HotelFloor floor = (HotelFloor) floors[i];
                double coeff = floor.getStar()*0.25;
                Space[] spaces = floor.getMasSpaces();
                for (int j = 0; j < spaces.length; j++) {
                    coeff *= spaces[i].getArea();
                    if (maxCoeff< coeff) bestSpace = spaces[j];
                }

            }
        }
        return bestSpace;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(String.format("Dwelling (%s, &s,  ",getCountFloors(), getMaxCoeff()));
        for (int i = 0; i < getCountFloors() ; i++) {
            stringBuilder.append(getFloor(i).toString()+", ");
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

}

