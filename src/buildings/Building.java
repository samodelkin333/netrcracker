package buildings;

public interface Building {
    //получения количества этажей в здании,
    int getCountFloors();
    //получения количества помещений в здании,
    int getSpaces();
    //получения общей площади всех помещений здания,
    double getAreaSpaces();
    //получения общего количества комнат в помещениях здания,
    int getRoomsFloors();
    //получения массива этажей здания,
    Floor[] getFloors();
    //получения этажа здания по его номеру,
    Floor getFloor(int index);
    //изменения этажа по его номеру и ссылке на новый этаж,
    void setFloor(int index, Floor floor);
    //получения помещения по его номеру в здании,
    Space getSpace(int index);
    //изменения помещения в здании по номеру и ссылке на новое помещение,
    void setSpace(int index, Space flat);
    //вставке помещения в здании по будущему номеру и ссылке на новое помещение,
    void addSpace(int index, Space flat);
    //удаления помещения из здания,
    void deleteSpace(int index);
    //получения лучшего помещения в здании,
    Space getBestSpaces();
    //получения отсортированного массива всех помещений.
    Space[] getSortedSpaceByArea();
}
