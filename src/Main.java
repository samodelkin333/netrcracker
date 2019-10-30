import buildings.Dwelling;
import buildings.DwellingFloor;
import buildings.Flat;
import  buildings.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class Main {
    public static void main(String[] arg) throws IOException{
        test3();
    }
    public static void test1(){
        Flat[] flats = new Flat[]{
                new Flat(),
                new Flat(15, 102),
                new Flat(10, 67),

        };

        Flat[] flats2 = new Flat[]{
                new Flat(),
                new Flat(12, 55),
                new Flat(11, 11),

        };

        DwellingFloor[] floors = new DwellingFloor[]{
                new DwellingFloor(flats2),
                new DwellingFloor(flats),
                new DwellingFloor(flats2)
        };

        DwellingFloor floor = new DwellingFloor(5);

        System.out.println("Работа с DwellingFloors");
        System.out.println("колличество комнат: "+floors[1].getRooms());
        System.out.println("колличество квартир: "+floors[1].getMasSpaces().length);
        System.out.println(floors[1].getMasSpaces().length);
        get(floors[1].getMasSpaces());
        System.out.println("Пример добавления элементов");
        floors[1].addSpace(3,new Flat());
        floors[1].addSpace(2,new Flat());
        floors[1].addSpace(0,new Flat());
        get(floors[1].getMasSpaces());
        //System.out.println(floors[1].getMasFlats().length);
        System.out.println("Пример удаления элементов");
        floors[1].deleteSpace(4);
        floors[1].deleteSpace(0);
        floors[1].deleteSpace(2);
        get(floors[1].getMasSpaces());
        System.out.println("максимальная площадь на этаже: "+floors[1].getBestSpace().getArea());
        System.out.println("Вывод квартиры по индексу"+floors[1].getSpace(2).getArea());

        System.out.println("------------------------");
        System.out.println("------------------------");
        System.out.println("------------------------");

        System.out.println("Работа с Dwelling");
        Dwelling dwelling = new Dwelling(floors);
        Flat flat = new Flat();
        dwelling.addSpace(0,flat);
        System.out.println("all rooms: "+ dwelling.getRoomsFloors());
        System.out.println("Check index add flat "+ dwelling.getSpace(0).getRoom());
        System.out.println("max areas: "+dwelling.getBestSpaces().getArea());
        dwelling.setSpace(0, flat);
        dwelling.setFloor(0,floor);
        System.out.println("------------------------");
        System.out.println(dwelling.getSpaces());
        System.out.println("before delete flat"+ dwelling.getSpace(0) );
        dwelling.deleteSpace(0);
        System.out.println();
        System.out.println(dwelling.getSpaces());
        System.out.println("---------------");
        System.out.println("after delete flat"+ dwelling.getSpace(0) );
        System.out.println("all rooms: "+ dwelling.getRoomsFloors());
        dwelling.getSpaces();
        dwelling.getFloors();
        dwelling.getFloor(1);
        System.out.println("areas: "+ dwelling.getSortedSpaceByArea());

        Space[] sortedFlats = dwelling.getSortedSpaceByArea();
        for (int i = 0; i < sortedFlats.length; i++) {
            System.out.println(sortedFlats[i].getArea());
        }

    }

    public static void test2(){
            Office[] offices = new Office[]{
            new Office(),
            new Office(15, 290),
            new Office(10, 67),

    };

        Office[] offices1 = new Office[]{
                new Office(),
                new Office(12, 55),
                new Office(11, 11),

        };
        Office office = new Office(12, 69);
        OfficeFloor floor = new OfficeFloor(offices);
        System.out.println(floor.getRooms());
        System.out.println(floor.getBestSpace().getArea());
        System.out.println(floor.getCountSpaces());
        System.out.println("add");
        get(floor.getMasSpaces());
        floor.addSpace(0,office);
        floor.addSpace(4,office);
        floor.addSpace(2,office);

        get(floor.getMasSpaces());
        System.out.println("delete:");
        floor.deleteSpace(0);
        floor.deleteSpace(1);
        floor.deleteSpace(3);
        get(floor.getMasSpaces());

        System.out.println(floor.getCountSpaces());
        Office office1 = new Office(23,767);
        floor.setSpace(2,office1);
        get(floor.getMasSpaces());

        System.out.println();
        System.out.println("-------------------------------");

        OfficeFloor floor1 = new OfficeFloor(offices);
        OfficeFloor floor2 = new OfficeFloor(offices1);

        OfficeFloor[] floors = new OfficeFloor[]{floor,floor1,floor2};

        OfficeBuilding officeBuilding = new OfficeBuilding(floors);
        System.out.println(officeBuilding.getSpaces());
        System.out.println("best areas: " + officeBuilding.getBestSpaces().getArea());
        Floor[] floors1 = officeBuilding.getFloors();
        for (int i = 0; i < officeBuilding.getCountFloors(); i++) {
            get(floors1[i].getMasSpaces());
        }
        System.out.println("delete check: ");
        officeBuilding.deleteSpace(5);
        officeBuilding.deleteSpace(8);
        officeBuilding.deleteSpace(0);
        floors1 = officeBuilding.getFloors();
        for (int i = 0; i < officeBuilding.getCountFloors(); i++) {
            get(floors1[i].getMasSpaces());
        }

        System.out.println("add check: ");
        officeBuilding.addSpace(2,new Office(11,34));
        officeBuilding.addSpace(4,new Office(45,23));
        officeBuilding.addSpace(5,new Office(56,3980));
        officeBuilding.addSpace(2,new Office(12,45));
        officeBuilding.addSpace(7,new Office(11,34));
        officeBuilding.addSpace(8,new Office(11,34));
        officeBuilding.addSpace(1,new Office(11,34));
        officeBuilding.addSpace(3,new Office(11,34));
        officeBuilding.addSpace(5,new Office(11,34));
        officeBuilding.addSpace(7,new Office(11,34));
        for (int i = 0; i < officeBuilding.getCountFloors(); i++) {
            get(floors1[i].getMasSpaces());
        }
        System.out.println("sort:");
        //System.out.println(officeBuilding.getRoomsFloors());
        get(officeBuilding.getSortedSpaceByArea());


    }

    public static void test3() throws IOException

    {
        Flat[] flats = new Flat[]{
                new Flat(),
                new Flat(15, 102),
                new Flat(10, 67),

        };

        Flat[] flats2 = new Flat[]{
                new Flat(),
                new Flat(12, 55),
                new Flat(11, 11),

        };

        DwellingFloor[] floors = new DwellingFloor[]{
                new DwellingFloor(flats2),
                new DwellingFloor(flats),
                new DwellingFloor(flats2)
        };

        Dwelling dwelling = new Dwelling(floors);

        Building building = dwelling;

        Buildings.outputBuilding(dwelling, new FileOutputStream("./test.txt"));



    }

    public static void get(Space[] flats){
        System.out.print("areas: ");
        for (int i = 0; i < flats.length ; i++) {
            System.out.print(flats[i].getArea()+" ");
        }
        System.out.println();
    }
    public static void get(Office[] offices){
        System.out.println("areas: ");
        for (int i = 0; i < offices.length; i++) {
            System.out.println(offices[i].getArea());
        }
        System.out.println();

    }


}
