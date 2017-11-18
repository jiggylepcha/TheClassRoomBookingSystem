package ExceptionClasses;

/**
 * Is thrown when the room requested is not available
 */
public class RoomNotAvailableException extends Exception {
    RoomNotAvailableException(String message)
    {
        super(message);
    }
}
