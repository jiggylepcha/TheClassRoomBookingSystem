package Classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Queue;

public class Admin extends Person implements Serializable{

    public static final long serialVersionUID = 5106679824202538712L;

    Admin(Credentials cred)
    {
        super(cred,1);
    }
    Admin(){}

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