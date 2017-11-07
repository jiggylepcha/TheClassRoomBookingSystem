package Classes;

public class Room {
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
