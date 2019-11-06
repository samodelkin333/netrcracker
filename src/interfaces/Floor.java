package interfaces;

import interfaces.Space;

import java.util.Iterator;

public interface Floor {
    Space iterator();
    int getCountSpaces();
    double getAreas();
    int getRooms();
    Space[] getMasSpaces();
    Space getSpace(int index);
    void setSpace(int index,Space space);
    void addSpace( int index,Space space);
    void deleteSpace(int index);
    Space getBestSpace();
}
