package buildings;

public class Dwelling implements Building{
    private Floor[] dwellingFloors;

    //Конструктор может принимать массив этажей дома.
    public Dwelling( DwellingFloor[] dwellingFloors) {
        Floor[] copyDwellingFloors = new DwellingFloor[dwellingFloors.length];
        System.arraycopy(dwellingFloors,0,copyDwellingFloors,0,dwellingFloors.length);
        this.dwellingFloors = copyDwellingFloors;
    }

    //Конструктор может принимать количество этажей и массив количества квартир поэтажам.
    public Dwelling(int countDwellingFloors, int countFlats){
        if(countDwellingFloors <= 0) throw new SpaceIndexOutOfBoundsException("floors <= 0");
        if(countFlats <=0) throw  new FloorIndexOutOfBoundsException("flats <= 0");
        Flat[] flats = new Flat[countFlats];
        dwellingFloors = new DwellingFloor[countDwellingFloors];
        for (int i = 0; i < countDwellingFloors ; i++) {
            dwellingFloors[i] = new DwellingFloor(i);
        }
    }

    //Создайте метод получения общего количества этажей дома.
    public int getCountFloors() {
        return dwellingFloors.length;
    }

    //Создайте метод получения общего количества квартир дома.
    public int getSpaces(){
        int countFlats = 0;
        for (int i = 0; i < dwellingFloors.length; i++) {
            countFlats += dwellingFloors[i].getCountSpaces();
        }

        return countFlats;
    }

    //Создайте метод получения общей площади квартир дома.
    public double getAreaSpaces(){
        double count = 0;
        for (int i = 0; i < dwellingFloors.length ; i++) {
            count+=dwellingFloors[i].getAreas();
        }
        return count;
    }

    //Создайте метод получения общего количества комнат дома.
    public int getRoomsFloors(){
        int rooms = 0;
        for (int i = 0; i < dwellingFloors.length ; i++) {
            rooms+= dwellingFloors[i].getRooms();
        }
        return rooms;
    }

    //Создайте метод получения массива этажей жилого дома.
    public Floor[] getFloors() {
        return dwellingFloors;
    }

    //Создайте метод получения объекта этажа, по его номеру в доме.
    public Floor getFloor(int index){
        if(index < 0 ||index >= dwellingFloors.length) throw new SpaceIndexOutOfBoundsException();
        return dwellingFloors[index];
    }

    //Создайте метод изменения этажа по его номеру в доме и ссылке на обновленный этаж.
    public void setFloor(int index, Floor floor){
        if(index < 0 ||index >= dwellingFloors.length) throw new SpaceIndexOutOfBoundsException();
        dwellingFloors[index] = floor;
    }

    public int[] getIndexFlat(int index)
    {
        if(index<0||index > getSpaces()) throw new SpaceIndexOutOfBoundsException();
        int count = 0;
        for (int i = 0; i < dwellingFloors.length ; i++) {
            for (int j = 0; j < dwellingFloors[i].getMasSpaces().length; j++) {
                if (count == index)  return new int[]{i,j};
                count++;
            }

        }
        return null;
    }
    //Создайте метод получения объекта квартиры по ее номеру в доме.
    public Space getSpace(int index){
        if(index<0||index >= getSpaces()) throw new SpaceIndexOutOfBoundsException();
        int[] indexFlat = getIndexFlat(index);
        if(indexFlat != null) return dwellingFloors[indexFlat[0]].getSpace(indexFlat[1]);
        return null;
    }

    //Создайте метод изменения объекта квартиры по ее номеру в доме и ссылке типа квартиры.
    public void setSpace(int index, Space flat){
        if(index<0||index >= getSpaces()) throw new SpaceIndexOutOfBoundsException();
        int[] indexFlat = getIndexFlat(index);
        if(indexFlat != null) dwellingFloors[indexFlat[0]].setSpace(indexFlat[1],flat);
    }

    //Создайте метод добавления квартиры в дом по будущему номеру квартиры в доме
    public void addSpace(int index, Space flat){
        if(index<0||index > getSpaces()) throw new SpaceIndexOutOfBoundsException();
        int[] indexFlat = getIndexFlat(index);
        if(indexFlat != null) dwellingFloors[indexFlat[0]].addSpace(indexFlat[1],flat);

    }

    //Создайте метод удаления квартиры по ее номеру в доме.
    public void deleteSpace(int index) {
        if(index<0||index >= getSpaces()) throw new SpaceIndexOutOfBoundsException();
        int[] indexFlat = getIndexFlat(index);
        if(indexFlat != null) dwellingFloors[indexFlat[0]].deleteSpace(indexFlat[1]);
    }

    //Создайте метод getBestSpaces() получения самой большой по площади квартиры дома.
    public Space getBestSpaces(){
        Space maxFlat= dwellingFloors[0].getSpace(0);
        for (int i = 0; i < dwellingFloors.length ; i++) {
            if (maxFlat.getArea() < dwellingFloors[i].getBestSpace().getArea())maxFlat = dwellingFloors[i].getBestSpace();

        }
        return maxFlat;
    }

    //Создайте метод получения отсортированного по убыванию площадей массива квартир.
    public Space[] getSortedSpaceByArea(){
        Space[] flats = new Flat[getSpaces()];
        int count = 0;
        for (int i = 0; i < dwellingFloors.length; i++) {
            Space[] curFlats = dwellingFloors[i].getMasSpaces();
            System.arraycopy(curFlats, 0, flats, count, curFlats.length);
            count+=curFlats.length;
        }

        for (int i = 0; i < flats.length; i++) {
            for (int j = 0; j < flats.length; j++) {
                if(flats[i].getArea() > flats[j].getArea()){
                    Space flat = flats[i];
                    flats[i] = flats[j];
                    flats[j] = flat;
                }
            }
        }

        return flats;
    }

}
