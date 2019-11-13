package buildings.office;

import buildings.exception.InvalidRoomsCountException;
import buildings.exception.InvalidSpaceAreaException;
import interfaces.Space;
import java.util.Objects;
import java.io.Serializable;
import java.lang.*;


public class Office implements Space, Serializable {
    private int room;
    private double area;
    private static final int standartRoom = 1;
    private static final double standartArea = 250;
    public Office(){
        this(standartRoom, standartArea);
    }

    public Office(double area){
        this(standartRoom,area);
    }

    public Office(int room, double area){
        if(area <=0) throw new InvalidSpaceAreaException("areas <= 0");
        if(room<=0) throw new InvalidRoomsCountException("room <= 0");
        this.room = room;
        this.area = area;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        if(room<=0) throw new InvalidRoomsCountException("room <= 0");
        this.room = room;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {

        if(area <=0) throw new InvalidSpaceAreaException("areas <= 0");
        this.area = area;
    }

    @Override
    public String toString() {
        return String.format("Office (%s, %s)",room,area);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Office)) return false;
        Office office = (Office) o;
        return (this.room == office.room) && (Double.compare(this.area, office.area)==0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, area);
    }
}
