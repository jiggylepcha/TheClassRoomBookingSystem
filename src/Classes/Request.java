package Classes;

import java.io.Serializable;

public class Request implements Serializable
{
    private String preferredRoom;
    private String purposeBooking;
    private String requiredCapacity;
    private String day;
    private String time;

    Request(String room, String purpose, String capacity, String day, String time)
    {
        this.preferredRoom = room;
        this.purposeBooking = purpose;
        this.requiredCapacity = capacity;
        this.day = day;
        this.time = time;
    }



    public String getPreferredRoom()
    {
        return preferredRoom;
    }

    public String getPurposeBooking()
    {
        return purposeBooking;
    }

    public String getRequiredCapacity()
    {
        return requiredCapacity;
    }
}
