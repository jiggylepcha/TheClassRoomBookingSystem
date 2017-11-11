package Classes;

public class Faculty extends Person {

    Faculty(Credentials credentials)
    {
        super(credentials,2);
    }

    public boolean checkRoomAvailability(Room r)
    {
        return true;
    }

    public void bookRoom()
    {

    }

    public void cancelRoomBooking(Room r)
    {

    }
}
