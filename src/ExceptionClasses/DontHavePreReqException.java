package ExceptionClasses;

/**
 * Is thrown when the student does not have prereq
 */
public class DontHavePreReqException extends Exception{
    DontHavePreReqException(String message)
    {
        super(message);
    }
}
