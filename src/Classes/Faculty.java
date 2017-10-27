package Classes;

public class Faculty extends Person {
    Faculty(String n, String email)
    {
        super(n, email, "Faculty");
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
