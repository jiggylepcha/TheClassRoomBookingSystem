package ExceptionClasses;

public class InvalidEmailException extends Exception{
    InvalidEmailException(String message)
    {
        super(message);
    }
}
