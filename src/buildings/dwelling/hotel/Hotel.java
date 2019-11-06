package buildings.dwelling.hotel;

import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;
import interfaces.Floor;
import interfaces.Space;

public class Hotel extends Dwelling {

    private HotelFloor[] floors;

    public Hotel(int countFloors, int countSpaces){
        super(countFloors,countSpaces);


    }

    public Hotel(Floor[] floors){
        super(floors);
    }

//    public double getMaxCoeff(){
//        double maxCoef = 0;
//        for (int i = 0; i < floors.length ; i++) {
//           // if (floors[i] instanceof HotelFloor||maxCoef< floors[i].getCoeff())
//
//        }
//        return null;
//    }

    public Space getBestSpace(){

        return  null;
    }
}
