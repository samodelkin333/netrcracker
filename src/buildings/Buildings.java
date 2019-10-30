package buildings;

import java.io.*;

public class Buildings {

    public static void outputBuilding (Building building, OutputStream out) throws IOException
    {
        OutputStreamWriter writer = new OutputStreamWriter(out);
        Floor[] floors = building.getFloors();
        writer.write(floors.length);
        for (int i = 0; i < floors.length ; i++) {
            writer.write(floors[i].getCountSpaces());
            for (int j = 0; j < floors[i].getCountSpaces(); j++) {
                Space space = floors[i].getSpace(j);
                writer.write(space.getRoom());
                writer.write((int)space.getArea());
            }
        }
        writer.close();
    }


    public static Building inputBuilding (InputStream in) throws IOException{
        StreamTokenizer tokenizer = new StreamTokenizer(new InputStreamReader(in));
        tokenizer.nextToken();
        int countFloors = (int) tokenizer.nval;
        Floor[] floors= new Floor[countFloors];
        for (int i = 0; i < countFloors; i++) {
            tokenizer.nextToken();
            int countSpace = (int) tokenizer.nval;
            for (int j = 0; j < countSpace ; j++) {
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

    public static void writeBuilding (Building building, Writer out) throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(out);
        Floor[] floors = building.getFloors();
        bufferedWriter.write(floors.length);
        for (int i = 0; i < floors.length; i++) {
            bufferedWriter.write(floors[i].getCountSpaces());
            for (int j = 0; j < floors[i].getCountSpaces(); j++) {
                bufferedWriter.write(floors[i].getSpace(j).getRoom());
                bufferedWriter.write((int)floors[i].getSpace(j).getArea());
            }

        }
    }

    public static Building readBuilding (Reader in) throws IOException{
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        int countFloors = (int) tokenizer.nval;
        Floor[] floors= new Floor[countFloors];
        for (int i = 0; i < countFloors; i++) {
            tokenizer.nextToken();
            int countSpace = (int) tokenizer.nval;
            for (int j = 0; j < countSpace ; j++) {
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
