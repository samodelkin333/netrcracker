package buildings;

public class OfficeFloorNode {

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

