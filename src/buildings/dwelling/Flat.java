package buildings.dwelling;

import buildings.exception.InvalidRoomsCountException;
import buildings.exception.InvalidSpaceAreaException;
import interfaces.Space;

import java.io.*;
import java.util.Objects;

public class Flat implements Space, Serializable {
    private int room;
    private double area;
    private static final int standartRoom = 2;
    private static final double standartArea = 50;
    public Flat(){
        this(standartRoom, standartArea);
    }

    public  Flat (double area){
        this(standartRoom,area);
    }

    public  Flat (int room, double area){
        if(area <=0) throw new InvalidSpaceAreaException("areas <= 0");
        if(room<=0) throw new InvalidRoomsCountException("room <= 0");
        this.room = room;
        this.area = area;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        if(room<=0) throw new InvalidRoomsCountException("room <= 0 ");
        this.room = room;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if(area <=0) throw new InvalidSpaceAreaException("areas <= 0");
        this.area = area;
    }

    public String toString(){
        return String.format("Flat (%s, %s)",room,area);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Flat) return false;
        Flat flat = (Flat) o;
        return room == flat.room && Double.compare(flat.area, area) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, area);
    }
}
