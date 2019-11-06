package buildings;

import java.io.Serializable;

public class OfficeNode implements Serializable {
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
//