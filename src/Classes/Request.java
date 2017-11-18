package Classes;
/**
 * Request Class containing the details of the various requests made by the students
 */

import java.io.Serializable;

public class Request implements Serializable
{
    private String preferredRoom;
    private String purposeBooking;
    private String requiredCapacity;
    private String day;
    private String time;

    /**
     * Constructor to initialise the request details
     * @param room Room to be booked
     * @param purpose Purpose of booking
     * @param capacity Capacity of the room
     * @param day Day to be booked
     * @param time Time to be booked
     */

    Request(String room, String purpose, String capacity, String day, String time)
    {
        this.preferredRoom = room;
        this.purposeBooking = purpose;
        this.requiredCapacity = capacity;
        this.day = day;
        this.time = time;
    }


    /**
     * Gets the preferred room
     * @return Gets the preferred room
     */
    public String getPreferredRoom()
    {
        return preferredRoom;
    }

    /**
     * Getter
     * @return Gets the purpose of booking
     */
    public String getPurposeBooking()
    {
        return purposeBooking;
    }

    /**
     * Getter
     * @return Gets the required capacity
     */
    public String getRequiredCapacity()
    {
        return requiredCapacity;
    }

    public String getDay()
    {
        return day;
    }
    public String getTime()
    {
        return time;
    }
}
