package Classes;

import java.io.Serializable;

public class Room implements Serializable{

    public static final long serialVersionUID = 1231143L;

    private String roomNumber;
    private String mondayBookings;
    private String tuesdayBookings;
    private String wednesdayBookings;
    private String thursdayBookings;
    private String fridayBookings;

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getMondayBookings() {
        return mondayBookings;
    }

    public void setMondayBookings(String mondayBookings) {
        this.mondayBookings = mondayBookings;
    }

    public String getTuesdayBookings() {
        return tuesdayBookings;
    }

    public void setTuesdayBookings(String tuesdayBookings) {
        this.tuesdayBookings = tuesdayBookings;
    }

    public String getWednesdayBookings() {
        return wednesdayBookings;
    }

    public void setWednesdayBookings(String wednesdayBookings) {
        this.wednesdayBookings = wednesdayBookings;
    }

    public String getThursdayBookings() {
        return thursdayBookings;
    }

    public void setThursdayBookings(String thursdayBookings) {
        this.thursdayBookings = thursdayBookings;
    }

    public String getFridayBookings() {
        return fridayBookings;
    }

    public void setFridayBookings(String fridayBookings) {
        this.fridayBookings = fridayBookings;
    }

}
