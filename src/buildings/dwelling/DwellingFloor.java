package buildings.dwelling;

import interfaces.Floor;
import interfaces.Space;
import buildings.exception.SpaceIndexOutOfBoundsException;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DwellingFloor implements Floor, Serializable, Cloneable {
    private Space[] flats;

    //Конструктор может принимать массив квартир этажа.
    public  DwellingFloor(Space[] flats){
        Space[] copyFlats = new Space[flats.length];
        System.arraycopy(flats,0,copyFlats,0,copyFlats.length);
        this.flats = flats;
    }

    //Конструктор может принимать количество квартир на этаже.
    public DwellingFloor(int count){
        if (count < 0) throw new SpaceIndexOutOfBoundsException("count <0");
        flats = new Flat[count];
        for (int i = 0; i < flats.length ; i++) {
            flats[i] = new Flat();
        }
    }

    @Override
    public Iterator<Space> iterator() {
        return null;
    }

    private class SpaceIterator implements Iterator<Space> {
        int index = 0;

        public boolean hasNext() {
            if (index < flats.length) return true;
            return false;
        }

        @Override
        public Space next() {
            if(index< flats.length) {
                return flats[index++];
            }
            throw new NoSuchElementException();
        }
    }


    //Создайте метод получения количества квартир на этаже.
    public int getCountSpaces()
    {
        return flats.length;
    }

    //Создайте метод получения общей площади квартир этажа.
    public double getAreas()
    {
        double allArea=0;
        for (int i = 0; i <flats.length; i++) {
                allArea += flats[i].getArea();
        }

        return allArea;
    }


    //Создайте метод получения массива квартир этажа.
    public Space[] getMasSpaces() {
        Space[] retFlats = new Space[flats.length];
        int curIndex = 0;
        for (int i = 0; i < flats.length; i++) {
                retFlats[curIndex] = flats[i];
                curIndex++;
        }
        return retFlats;
    }

    //Создайте метод получения общего количества комнат этажа.
    public int getRooms(){
        int allRooms = 0;
        for (int i = 0; i < flats.length ; i++) {
            allRooms += flats[i].getRoom();
        }
        return allRooms;
    }

    //Создайте метод получения объекта квартиры, по ее номеру на этаже.
    public Space getSpace(int index){
        if(index< 0 || index >= flats.length) throw new SpaceIndexOutOfBoundsException("incorrect index");
        return flats[index];
    }

    //Создайте метод изменения квартиры по ее номеру на этаже и ссылке на новую квартиру.
    public void setSpace( int index,Space flat){
        if(index< 0 || index >= flats.length) throw new SpaceIndexOutOfBoundsException("incorrect index");
        flats[index] = flat;
    }

    //Создайте метод добавления новой квартиры на этаже по будущему номеру квартиры...
    public void addSpace(int index,Space flat){
        if(index< 0 || index > flats.length) throw new SpaceIndexOutOfBoundsException("incorrect index");
        Space[] copyFlats = new Flat[flats.length+1];
        System.arraycopy(flats,0,copyFlats,0,flats.length);
        if (index < flats.length) {
            flats = shiftRight(index, copyFlats);
            flats[index] = flat;
        }
        if(index == flats.length){
            flats = copyFlats;
            flats[index] = flat;
        }

    }

    //Создайте метод удаления квартиры по ее номеру на этаже.
    public void deleteSpace(int index){
        if(index< 0 || index >= flats.length) throw new SpaceIndexOutOfBoundsException("incorrect index");
        Space[] copyFlats = new Flat[flats.length-1];
        if(index == flats.length-1){
            System.arraycopy(flats,0,copyFlats,0,copyFlats.length);
            flats = copyFlats;
        }
        if (index < flats.length-1)
            flats = shiftLeft(index,copyFlats);
    }

    private Space[] shiftRight(int index, Space[] spaces){
        //Flat[] copyflats  = new Flat[flats.length+1];
       // System.arraycopy(flats,0,copyflats,0,flats.length);
        System.arraycopy(flats, index, flats, index+1,  flats.length - index - 1);
        flats[index]  = null;
        return flats;
    }

    private Space[] shiftLeft(int index, Space[] flats){
        System.arraycopy(this.flats,0,flats,0,index+1);
        System.arraycopy(this.flats, index+1, flats, index,  flats.length - index);
        return flats;
    }

    //Создайте метод getBestSpaces() получения самой большой по площади квартиры этажа.
    public Space getBestSpace(){
        Space maxFlat = flats[0];
        for (int i = 1; i < flats.length ; i++) {
            if (maxFlat.getArea() <= flats[i].getArea()) {
                maxFlat = flats[i];
            }
        }
        return maxFlat;
    }

}
