package buildings;

public class InvalidRoomsCountException extends IllegalArgumentException{
    InvalidRoomsCountException(){ super();}
    InvalidRoomsCountException(String message){ super(message);}
}
