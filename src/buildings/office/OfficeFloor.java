package buildings.office;

import interfaces.Floor;
import interfaces.Space;
import buildings.exception.SpaceIndexOutOfBoundsException;

import java.io.Serializable;

public class OfficeFloor implements Floor, Serializable {
    private int size;
    private  OfficeNode head;
    private  OfficeNode tail;

    public OfficeFloor(int officeCount){
        for (int i = 0; i < officeCount ; i++) {
          add(new OfficeNode(new Office()));
        }

    }

    public OfficeFloor(Office[] offices){
        for (int i = 0; i < offices.length; i++) {
            add(new OfficeNode(offices[i]));
        }

    }

    private void add( OfficeNode node){
        if(size == 0){
            head = node;
        }
        else{
            tail.next = node;
            node.next = head;
        }
        tail = node;
        size++;
    }

    private void add(int index, OfficeNode node){
        //if(index< 0 || index >= size) throw new SpaceIndexOutOfBoundsException("incorrect index");
        if(size == 0){
            head = node;
            node.next = head;
        }
        if(index == 0){
            node.next = head;
            head = node;
            tail.next = head;
        }
        else if (index == size-1){
            add(node);
            return;


        }else{
           OfficeNode curNode = get(index-1);
            node.next = curNode.next;
            curNode.next = node;
        }
        size++;

    }

    private OfficeNode get(int index){
        //if(index< 0 || index >= size) throw new SpaceIndexOutOfBoundsException("incorrect index");
        OfficeNode curNode = head;
        for (int i = 0; i < index ; i++) {
            curNode = curNode.next;
        }
        return curNode;
    }

    private void delete(int index){
        //if(index< 0 || index >= size) throw new SpaceIndexOutOfBoundsException("incorrect index");
        if (index == 0){
            head = head.next;
        }
        else if(index == size-1) {
            OfficeNode curNode  = head;
            for (int i = 0; i < index-1 ; i++) {
                curNode = curNode.next;

            }
            curNode.next = head;
        }
        else {
            OfficeNode curNode  = head;
            for (int i = 0; i <index-1 ; i++) {
                curNode = curNode.next;

            }
            curNode.next = curNode.next.next;
        }
        size--;
    }

    public int getCountSpaces(){
        return size;
    }

    public double getAries() {
        OfficeNode curNode = head ;
        double aries = 0;
        for (int i = 0; i < size ; i++) {
            aries += curNode.value.getArea();
            curNode = curNode.next;
        }
        return aries;
    }

    public  double getAreas(){
        double countAreas=0;
        OfficeNode curNode = head;
        for (int i = 0; i < size-1; i++) {
            countAreas+= curNode.value.getArea();
            curNode = curNode.next;
        }
        return  countAreas;
    }

    public  int getRooms(){
        int countRooms=0;
        OfficeNode curNode = head;
        for (int i = 0; i < size; i++) {
            countRooms+= curNode.value.getRoom();
            curNode = curNode.next;
        }
        return  countRooms;
    }

    public Space[] getMasSpaces(){
        Space[] offices = new Office[size];
        OfficeNode curNode = head;
        for (int i = 0; i < size; i++) {
            offices[i] = curNode.value;
            curNode = curNode.next;
        }
        return  offices;
    }

    public Space getSpace(int index){
        if(index< 0 || index >= size) throw new SpaceIndexOutOfBoundsException("incorrect index");
        return get(index).value;
    }

    public void setSpace(int index,Space office){
        if(index< 0 || index >= size) throw new SpaceIndexOutOfBoundsException("incorrect index");
        OfficeNode curNode = get(index);
        curNode.value = office;
    }

    public void addSpace(int index, Space office){
        if(index<0||index > size) throw new SpaceIndexOutOfBoundsException();
        add(index,new OfficeNode(office));
    }

    public void deleteSpace(int index){
        if(index<0||index >= size) throw new SpaceIndexOutOfBoundsException();
        delete(index);
    }

    public Space getBestSpace(){
        double maxCount = head.value.getArea();
        OfficeNode retNode = head;
        OfficeNode curNode = head.next;

        for (int i = 1; i <size-1 ; i++) {
            if(maxCount < curNode.value.getArea()){
                retNode = curNode;
                maxCount = curNode.value.getArea();
            }
            retNode = retNode.next;
            curNode = curNode.next;
        }
        return retNode.value;
    }

}
