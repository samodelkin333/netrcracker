package buildings;

import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFactory;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.dwelling.hotel.HotelFactory;
import buildings.dwelling.hotel.HotelFloor;
import interfaces.BuildingFactory;
import interfaces.Floor;
import interfaces.Building;
import interfaces.Space;

import java.io.*;

public class Buildings {

    private static BuildingFactory buildingFactory = new DwellingFactory();

    public static void setBuildingFactory(BuildingFactory buildingFactory) {
        Buildings.buildingFactory = buildingFactory;
    }

     public static Space createSpace(double area){
        return buildingFactory.createSpace(area);
     }

     public static Space createSpace(int roomsCount, double area){
        return buildingFactory.createSpace(roomsCount, area);
     }

     public static Floor createFloor(int spacesCount){
        return buildingFactory.createFloor(spacesCount);
     }

     public static Floor createFloor(Space[] spaces){
        return buildingFactory.createFloor(spaces);
     }

     public static Building createBuilding(int floorsCount, int[] spacesCounts) {
        return buildingFactory.createBuilding(floorsCount,spacesCounts);
    }

    public static Building createBuilding(Floor[] floors) {
        return buildingFactory.createBuilding(floors);
    }

    public static void outputBuilding(Building building, OutputStream out) throws IOException {
        DataOutputStream dos = new DataOutputStream(out);

        Floor[] floors = building.getFloors();
        dos.writeInt(floors.length);
        for (int i = 0; i < floors.length; i++) {
            if (buildingFactory instanceof HotelFactory){dos.writeInt(((HotelFloor) floors[i]).getStar());}
            dos.writeInt(floors[i].getCountSpaces());
            Space[] spaces = floors[i].getMasSpaces();
            for (int j = 0; j < spaces.length; j++) {
                dos.writeInt(spaces[j].getRoom());
                dos.writeDouble(spaces[j].getArea());
            }
        }
        dos.flush();
    }


    public static Building inputBuilding (InputStream in) throws IOException{
        DataInputStream dis = new DataInputStream(in);
        int countFloors = dis.readInt();
        Floor[] floors= new Floor[countFloors];
        int countStar = 0;
        for (int i = 0; i < floors.length; i++) {
            if(buildingFactory instanceof HotelFactory){
                countStar = dis.readInt();
            }
            int countSpace = dis.readInt();
            //System.out.println(countSpace);
            //floors[i] =  new buildingFactory.create;
            Space[] spaces = new Space[countSpace];
            for (int j = 0; j < countSpace ; j++) {
                int rooms = dis.readInt();
                double areas = dis.readDouble();
                //System.out.println(rooms+" "+ areas);
                //System.out.println(buildingFactory.createSpace(rooms,areas));

                spaces[j] = buildingFactory.createSpace(rooms,areas);

            }
            floors[i] = buildingFactory.createFloor(spaces);
            if (buildingFactory instanceof HotelFactory) ((HotelFloor)floors[i]).setStar(countStar);
        }
        dis.close();
        Building building = buildingFactory.createBuilding(floors);
        return building;
    }


    public static void writeBuilding (Building building, Writer out) throws IOException{
        Floor[] floors = building.getFloors();
        out.write(""+floors.length);
        for (int i = 0; i < floors.length; i++) {
            if (buildingFactory instanceof HotelFactory){out.write(" "+((HotelFloor) floors[i]).getStar());}
            out.write(" "+floors[i].getCountSpaces());
            for (int j = 0; j < floors[i].getCountSpaces(); j++) {
                out.write(" "+floors[i].getSpace(j).getRoom());
                out.write(" "+(floors[i].getSpace(j).getArea()));
            }

        }
        out.flush();
    }

    public static Building readBuilding (Reader in) throws IOException{
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        int countFloors = (int) tokenizer.nval;
        Floor[] floors = new Floor[countFloors];
        int countStar = 0;
        for (int i = 0; i < floors.length; i++) {
            tokenizer.nextToken();
            int countSpace = (int) tokenizer.nval;
            floors[i] = buildingFactory.createFloor(0);
            tokenizer.nextToken();
            if(buildingFactory instanceof HotelFactory){
                countStar = (int) tokenizer.nval;
            }

            Space[] space = new Space[countSpace];

            for (int j = 0; j < countSpace ; j++) {

                tokenizer.nextToken();
                int rooms = (int)tokenizer.nval;
                tokenizer.nextToken();

                double areas = tokenizer.nval;
                space[i] = new Flat(rooms,areas);
            }
            floors[i] = buildingFactory.createFloor(space);
            if (buildingFactory instanceof HotelFactory) ((HotelFloor)floors[i]).setStar(countStar);
        }
        Building building = buildingFactory.createBuilding(floors);
        return building;
    }

}
