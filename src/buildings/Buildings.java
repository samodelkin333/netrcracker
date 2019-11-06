package buildings;

import java.io.*;

public class Buildings {

    public static void outputBuilding(Building building, OutputStream out) throws IOException {
        DataOutputStream dos = new DataOutputStream(out);

        Floor[] floors = building.getFloors();
        dos.writeInt(floors.length);

        for (int i = 0; i < floors.length; i++) {
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
        DwellingFloor[] floors= new DwellingFloor[countFloors];
        for (int i = 0; i < floors.length; i++) {
            int countFlats = dis.readInt();
            floors[i] = new DwellingFloor(0);
            for (int j = 0; j < countFlats ; j++) {
                int rooms = dis.readInt();
                double areas = dis.readDouble();
                Flat flat = new Flat(rooms,areas);
                floors[i].addSpace(j,flat);
            }

        }
        Dwelling dwelling = new Dwelling(floors);
        return dwelling;
    }

    public static void writeBuilding (Building building, Writer out) throws IOException{
        Floor[] floors = building.getFloors();
        out.write(""+floors.length);
        for (int i = 0; i < floors.length; i++) {
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
        DwellingFloor[] floors = new DwellingFloor[countFloors];

        for (int i = 0; i < floors.length; i++) {
            tokenizer.nextToken();
            int countFlat = (int) tokenizer.nval;
            floors[i] = new DwellingFloor(0);

            for (int j = 0; j < countFlat ; j++) {
                tokenizer.nextToken();
                int rooms = (int)tokenizer.nval;
                tokenizer.nextToken();

                double areas = tokenizer.nval;

                Flat flat = new Flat(rooms,areas);
                floors[i].addSpace(j,flat);
            }

        }
        Dwelling dwelling = new Dwelling(floors);
        return dwelling;
    }

}
