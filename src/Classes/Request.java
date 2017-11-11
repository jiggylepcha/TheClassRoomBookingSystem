package Classes;

import java.io.Serializable;

public class Request implements Serializable
{
    private String preferredRoom;
    private String purposeBooking;
    private int requiredCapacity;

    Request(String room, String purpose, int capacity)
    {
        this.preferredRoom = room;
        this.purposeBooking = purpose;
        this.requiredCapacity = capacity;
    }

    public String getPreferredRoom()
    {
        return preferredRoom;
    }

    public String getPurposeBooking()
    {
        return purposeBooking;
    }

    public int getRequiredCapacity()
    {
        return requiredCapacity;
    }
}
