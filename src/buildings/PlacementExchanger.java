package buildings;

import buildings.exception.*;
import interfaces.Building;
import interfaces.Floor;
import interfaces.Space;

public class PlacementExchanger {

    public static boolean checkSpaces(Space space2, Space space){
        return (space.getRoom() == space2.getRoom() && space.getArea() == space2.getArea());
    }

    public static boolean checkFloors(Floor floor, Floor floor2){
        return (floor.getCountSpaces() == floor2.getCountSpaces() && floor.getAreas() == floor2.getAreas());
    }

    public static void exchangeFloorRooms(Floor floor1, int index1, Floor floor2, int index2) throws InexchangeableSpacesException
    {
        if(index1 > floor1.getCountSpaces()|| index2 > floor2.getCountSpaces() || index1 < 0 ||index2 < 0) throw new SpaceIndexOutOfBoundsException();
        Space space = floor1.getSpace(index1);
        Space space2 = floor2.getSpace(index2);
        if (!checkSpaces(space,space2)) throw new InexchangeableSpacesException();
        floor1.setSpace(index1,space2);
        floor2.setSpace(index2,space);
    }

    public static void exchangeBuildingFloors(Building building1, int index1, Building building2, int index2) throws InexchangeableFloorsException
    {
        if(index1 >  building1.getCountFloors() || index2 > building2.getCountFloors() || index1 > 0 || index2 >0) throw new FloorIndexOutOfBoundsException();
        Floor floor = building1.getFloor(index1);
        Floor floor2 = building2.getFloor(index1);
        if(!checkFloors(floor,floor2)) throw new InexchangeableFloorsException();
        building1.setFloor(index1,floor2);
        building2.setFloor(index2,floor);
    }

}
