package buildings;

public class OfficeNode {
    OfficeNode next;
    Space value;

    OfficeNode(){
        this(null);
    }

    OfficeNode(Space value){
        next = null;
        this.value = value;
    }
}
