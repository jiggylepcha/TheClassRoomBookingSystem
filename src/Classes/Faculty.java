package Classes;

/**
 * Gives detalis about the faculty
 * @author Nakul Ramanathan
 */
public class Faculty extends Person {
    /**
     * Constructor to initialise the Credentials to the Faculty
     * @param credentials email, password and type of user
     */
    Faculty(Credentials credentials)
    {
        super(credentials,2);
    }

    /**
     * Checks the room availability
     * @param r Room object
     * @return true if available otherwise false
     */
    public boolean checkRoomAvailability(Room r)
    {
        return true;
    }

    /**
     * This functions books the room if available
     */
    public void bookRoom()
    {

    }

    /**
     * Cancels the room booking
     * @param r Room object
     */
    public void cancelRoomBooking(Room r)
    {

    }
}
