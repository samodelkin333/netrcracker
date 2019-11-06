package buildings.office;

import interfaces.Floor;

import java.io.Serializable;

public class OfficeFloorNode implements Serializable {

    OfficeFloorNode next;
    OfficeFloorNode previous;
    Floor value;

    OfficeFloorNode(){
        this(null);
    }

    OfficeFloorNode(Floor value){
        next = null;
        previous = null;
        this.value = value;
    }


}

