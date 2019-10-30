package buildings;

public class InvalidSpaceAreaException extends IllegalArgumentException{
    InvalidSpaceAreaException(){ super();}
    InvalidSpaceAreaException(String message){ super(message);}
}
