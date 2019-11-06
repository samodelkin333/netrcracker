import buildings.Dwelling;
import buildings.DwellingFloor;
import buildings.Flat;
import  buildings.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) throws IOException,ClassNotFoundException, InexchangeableSpacesException{
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

    public static void test3() throws IOException, ClassNotFoundException,InexchangeableSpacesException
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

        Dwelling dwelling = new Dwelling(floors);

        Building building = dwelling;

        Buildings.outputBuilding(dwelling, new FileOutputStream("./test.txt"));
        Building building1 =  Buildings.inputBuilding(new FileInputStream("./test.txt"));
        Dwelling dwelling1 = new Dwelling(building1.getFloors());
        for (int i = 0; i < dwelling1.getCountFloors() ; i++) {
            get(dwelling1.getFloor(i).getMasSpaces());
        }

        Buildings.writeBuilding(dwelling, new FileWriter("./test1.txt"));
        Building building2 = Buildings.readBuilding(new FileReader("./test1.txt"));
        dwelling1 = new Dwelling(building2.getFloors());

        for (int i = 0; i < dwelling1.getCountFloors() ; i++){
            get(dwelling1.getFloor(i).getMasSpaces());
        }

        Flat flat = flats[1];
        System.out.println("кол-во комнат квартиры: "+ flat.getRoom()+" площадь квартиры: "+ flat.getArea());

        //сереализация flat
        FileOutputStream outputStream = new FileOutputStream("./saveFlat.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(flat);
        objectOutputStream.close();

        FileInputStream inputStream = new FileInputStream("./saveFlat.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Flat serFlat = (Flat)objectInputStream.readObject();
        System.out.println("кол-во комнат квартиры: "+serFlat.getRoom()+" площадь квартиры: "+ serFlat.getArea());


        DwellingFloor dwellingFloor = new DwellingFloor(flats) ;
        System.out.println("кол-во квартир: "+dwellingFloor.getCountSpaces());
        objectOutputStream = new ObjectOutputStream(new FileOutputStream("./saveDwellingFloor.txt"));
        objectOutputStream.writeObject(dwellingFloor);
        objectOutputStream.close();

        objectInputStream = new ObjectInputStream(new FileInputStream("./saveDwellingFloor.txt"));
        dwellingFloor = (DwellingFloor) objectInputStream.readObject();
        System.out.println("кол-во квартир: "+dwellingFloor.getCountSpaces());

       OfficeFloor officeFloor = new OfficeFloor(offices);
        System.out.println("кол-во оф: "+ officeFloor.getCountSpaces());
        objectOutputStream = new ObjectOutputStream(new FileOutputStream("./saveOfficeFloor.txt"));
        objectOutputStream.writeObject(officeFloor);
        objectOutputStream.close();

        objectInputStream = new ObjectInputStream(new FileInputStream("./saveOfficeFloor.txt"));
        officeFloor = (OfficeFloor) objectInputStream.readObject();
        System.out.println("кол-во оф: "+officeFloor.getCountSpaces());


        PlacementExchanger placementExchanger = new PlacementExchanger();
        Floor floor = dwellingFloor;
        placementExchanger.exchangeFloorRooms(floor,0,floor,0);



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
