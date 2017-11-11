package Classes;

import java.io.Serializable;

public class Admin extends Person implements Serializable{


    Admin(Credentials cred)
    {
      super(cred,1);
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