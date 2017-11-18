package ExceptionClasses;

/**
 * Is thrown when the user enters a room which does not exist
 */
public class InvalidRoomException extends Exception {
    InvalidRoomException(String message)
    {
        super(message);
    }
}
