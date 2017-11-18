package Classes;
/**
 * This class contains the details of the Room class.
 * @author Nakul Ramanathan
 */

import java.io.Serializable;

public class Room implements Serializable{

    public static final long serialVersionUID = 1231143L;

    private String roomNumber;
    private String mondayBookings;
    private String tuesdayBookings;
    private String wednesdayBookings;
    private String thursdayBookings;
    private String fridayBookings;

    /**
     * Default constructor
     */
    public Room()
    {

    }

    /**
     * Gets the room number
     * @return Room number
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * Setter
     * @param roomNumber sets the room number
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Getter
     * @return Returns the monday booking
     * */
    public String getMondayBookings() {
        return mondayBookings;
    }

    /**
     * Setter
     * @param mondayBookings sets the monday booking
     */

    public void setMondayBookings(String mondayBookings) {
        this.mondayBookings = mondayBookings;
    }

    /**
     * Gets the tuesday booking
     * @return tuesday booking
     */
    public String getTuesdayBookings() {
        return tuesdayBookings;
    }
    /**
     * Setter
     * @param tuesdayBookings sets the tuesday booking
     */
    public void setTuesdayBookings(String tuesdayBookings) {
        this.tuesdayBookings = tuesdayBookings;
    }

    /**
     * Gets the wednesday booking
     * @return wednesday booking
     */
    public String getWednesdayBookings() {
        return wednesdayBookings;
    }

    /**
     * Sets the wednesday booking
     * @param wednesdayBookings wednesday booking
     */
    public void setWednesdayBookings(String wednesdayBookings) {
        this.wednesdayBookings = wednesdayBookings;
    }

    /**
     * Gets the thursday booking
     * @return thursday booking
     */
    public String getThursdayBookings() {
        return thursdayBookings;
    }

    /**
     * Sets the thursday booking
     * @param thursdayBookings thursday booking
     */
    public void setThursdayBookings(String thursdayBookings) {
        this.thursdayBookings = thursdayBookings;
    }

    /**
     * Gets the friday booking
     * @return friday booking
     */
    public String getFridayBookings() {
        return fridayBookings;
    }

    /**
     * Sets the friday booking
     * @param fridayBookings friday booking
     */
    public void setFridayBookings(String fridayBookings) {
        this.fridayBookings = fridayBookings;
    }

}
