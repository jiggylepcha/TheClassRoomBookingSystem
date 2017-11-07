package Classes;

public class Admin extends Person{

    Admin(String n, String e)
    {
        super(n, e, "Admin");
    }
    public boolean checkRoomAvailibility()
    {
        return true;
    }

    public void cancelRoomBooking()
    {

    }

    public void acceptRoomBooking(Room r)
    {

    }

    public void bookRoom()
    {

    }


}