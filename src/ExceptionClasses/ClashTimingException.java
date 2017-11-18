package ExceptionClasses;

/**
 * Is thrown when the timings clash
 */
public class ClashTimingException extends Exception {
    ClashTimingException(String message)
    {
        super(message);
    }
}
