package buildings.office;

import interfaces.Floor;
import buildings.exception.FloorIndexOutOfBoundsException;
import buildings.exception.SpaceIndexOutOfBoundsException;
import interfaces.Building;
import interfaces.Space;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OfficeBuilding implements Building, Serializable {
    private int size;
    private  OfficeFloorNode head;
    private  OfficeFloorNode tail;

    public OfficeBuilding(int[] officeCount, int floorCount){
        if(floorCount <=0) throw  new FloorIndexOutOfBoundsException("index <= 0");
        size=0;
        for (int i = 0; i < floorCount ; i++) {
            if(officeCount[i] <= 0) throw new SpaceIndexOutOfBoundsException("index <= 0");
            add(size,new OfficeFloorNode(new OfficeFloor (officeCount[i])));
        }

    }

    public  OfficeBuilding(Floor[] officeFloors){
        size = 0;
        for (int i = 0; i < officeFloors.length; i++) {
            add(i,new OfficeFloorNode(officeFloors[i]));
        }

    }

    @Override
    public Iterator<Floor> iterator() {
        return new FloorIterator();
    }

    private class FloorIterator implements Iterator<Floor> {
        int index = 0;
        OfficeFloorNode curNode  = head;
        public boolean hasNext() {
            if (index < size) return true;
            return false;
        }

        @Override
        public Floor next() {
            if(hasNext()) {
                OfficeFloorNode retNode = curNode;
                curNode = curNode.next;
                return retNode.value;
            }
            throw new NoSuchElementException();
        }
    }




    private void add(int index, OfficeFloorNode node){
        //if (index > size) throw new FloorIndexOutOfBoundsException("index > size");
        if(size == 0){
            head = node;
            node.next = head;
            node.previous = head;
        }
        else if(index == 0){
            head.previous = node;
            node.next = head;
            head = node;
            head.previous = tail;
        }
        else if (index == size-1){
            tail.next = node;
            node.previous = tail;
            tail = node;
            tail.next = head;

        }else{
            OfficeFloorNode curNode  = get(index);
            node.previous = curNode.previous;
            curNode.previous.next = node;
            node.next = curNode;
            curNode.previous = node;
        }
        size++;

    }

    private void delete(int index){
        if (index > size) throw new FloorIndexOutOfBoundsException("index > size");
            if(index==0){
                head.next.previous = tail;
                tail.next = head.next;
            }
            else if(index == size-1){
                tail.previous.next = head;
            }
            else{
                OfficeFloorNode curNode =  get(index);
                curNode.previous.next = curNode.next;
                curNode.next.previous = curNode.previous;
            }

    }

    private OfficeFloorNode get(int index) {
        //if (index > size) throw new FloorIndexOutOfBoundsException("index > size");
        OfficeFloorNode curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode;
    }

    public int getCountFloors(){
        return size;
    }

    public int getSpaces(){
        int countOffices=0;
        OfficeFloorNode curHonde = head;
        for (int i = 0; i < size; i++) {
            countOffices+= curHonde.value.getCountSpaces();
            curHonde=curHonde.next;
        }
        return countOffices;
    }

    public double getAreaSpaces(){
        OfficeFloorNode curHonde = head;
        double count = 0;
        for (int i = 0; i < size ; i++) {
            count+= curHonde.value.getAreas();
        }
        return count;
    }


    public int getRoomsFloors() {
        OfficeFloorNode curHonde = head;
        int count = 0;
        for (int i = 0; i < size ; i++) {
            count+= curHonde.value.getRooms();
        }
        return count;
    }

    public Floor[] getFloors(){
        Floor[] officeFloors = new Floor[size];
        OfficeFloorNode curNode = head;
        for (int i = 0; i < size; i++) {
            officeFloors[i] = curNode.value;
            curNode = curNode.next;
        }
        return officeFloors;
    }

    public Floor getFloor(int index){
        if(index<0||index >= size) throw new SpaceIndexOutOfBoundsException();
        OfficeFloorNode curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.value;
    }

    public void setFloor(int index,Floor floor){
        if(index<0||index >= size) throw new SpaceIndexOutOfBoundsException();
        OfficeFloorNode curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        curNode.value = floor;
    }

    public Space getSpace(int index){
        if (index<0||index >= getSpaces()) throw new FloorIndexOutOfBoundsException();
        OfficeFloorNode curNode = head;
        int count = 0;
        Space retSpace = null;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < curNode.value.getCountSpaces() ; j++) {
                if(count == index) retSpace = curNode.value.getSpace(j);
            }
        }
        return  retSpace;
    }

    public void setSpace(int index,Space office){
        if (index<0||index > getSpaces()) throw new FloorIndexOutOfBoundsException();
        OfficeFloorNode curNode = head;
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < curNode.value.getCountSpaces() ; j++) {
                if(count == index) curNode.value.setSpace(j,office);
            }
        }
    }

    public void addSpace( int index, Space office){
        if (index<0||index > getSpaces()) throw new FloorIndexOutOfBoundsException();
        //if (index > size) throw new FloorIndexOutOfBoundsException("index > size");
        OfficeFloorNode curNode = head;
        int count = 0;
        for (int i = 0; i < index; i++) {
            count+= curNode.value.getCountSpaces();
            if (index <= count) {curNode.value.addSpace(index,office); return;}
            curNode = curNode.next;
        }
    }

    public void deleteSpace(int index){

        if (index<0||index > getSpaces()) throw new FloorIndexOutOfBoundsException();
        OfficeFloorNode curNode = head;
        int count = 0;
        for (int i = 0; i < index; i++) {
            //Office[] offices = curNode.value.getMasOffices();
            count+= curNode.value.getCountSpaces();
            if (index <= count) {curNode.value.deleteSpace(i); return;}
            curNode = curNode.next;
        }
    }

    public Space getBestSpaces(){
        Space maxOffice = head.value.getBestSpace();
        OfficeFloorNode curNode = head.next;
        for (int i = 0; i < size-1; i++) {
            if (maxOffice.getArea() < curNode.value.getBestSpace().getArea()) maxOffice = curNode.value.getBestSpace() ;
        }
        return maxOffice;
    }

    public Space[] getSortedSpaceByArea(){
        OfficeFloorNode curNode = head;
        Office[] offices = new Office[getSpaces()];
        int count = 0;
        for (int i = 0; i < size; i++) {
            //System.out.println(count);
            Space[] curOffice = curNode.value.getMasSpaces();
            System.arraycopy(curOffice, 0, offices, count, curOffice.length);
            count+=curOffice.length;
            curNode = curNode.next;

        }

        for (int i = 0; i < offices.length; i++) {
            for (int j = 0; j < offices.length; j++) {
                if(offices[i].getArea() > offices[j].getArea()){
                    Office office = offices[i];
                    offices[i] = offices[j];
                    offices[j] = office;
                }
            }
        }
        return offices;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(String.format("OfficeBuilding (%s, ", size));
        OfficeFloorNode curNode = head;
        for (int i = 0; i < size ; i++) {
            stringBuilder.append(curNode.value.toString()+", ");
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
