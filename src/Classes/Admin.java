package Classes;
/**
 * Admin Class which contains the details of the admin. What it can do what it cannot.
 * @author Jigme Lobsang Lepcha
 * @author Nakul Ramanathan
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Queue;

public class Admin extends Person implements Serializable{

    public static final long serialVersionUID = 5106679824202538712L;

    /**
     *
     * @param cred Credential class which includes the name, email and password of the user
     */
    Admin(Credentials cred)
    {
        super(cred,1);
    }
    Admin(){}

    /**
     * Checks Room Availability
     * @return returns true if room is available for booking else false
     */
    public boolean checkRoomAvailibility()
    {
        return true;
    }

    /**
     * Cancels the room booking
     */
    public void cancelRoomBooking()
    {

    }

    /**
     * Accepts the room booking request made by the student
     * @param r
     */
    public void acceptRoomBooking(Room r)
    {

    }

    /**
     * This function book rooms
     */
    public void bookRoom()
    {

    }
    /** This function serialises the Student Request Queue*/
    public void serialiseRequest(Queue<Request> r) throws IOException
    {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("req.ser"));
            out.writeObject(r);
        } finally {
            out.close();
        }
    }
    /**This function deserialises the Student Request Queue*/
    public Queue<Request> deserialiseRequest() throws IOException, ClassNotFoundException
    {
        ObjectInputStream in = null;
        Queue<Request> req = null;
        try {
            in = new ObjectInputStream(new FileInputStream("csv.ser"));
            req = (Queue<Request>) in.readObject();
        } finally {
            in.close();
        }

        return req;
    }
}