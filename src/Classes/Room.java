package Classes;

import java.io.Serializable;

public class Room implements Serializable{

    public static final long serialVersionUID = 1231143L;

    private String roomNumber;
    private int roomCapacity;
    private boolean roomAvailability;

    public String getRoomNumber()
    {
        return roomNumber;
    }

    public int getRoomCapacity()
    {
        return roomCapacity;
    }

    public boolean getRoomAvailability()
    {
        return roomAvailability;
    }

    public void setRoomNumber(String rn)
    {
        roomNumber = rn;
    }

    public void setRoomCapacity(int rc)
    {
        roomCapacity = rc;
    }

    public void setRoomAvailability(boolean ra)
    {
        roomAvailability = ra;
    }
}
