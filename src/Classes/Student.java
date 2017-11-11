package Classes;

import java.io.Serializable;

public class Student extends Person implements Serializable{

    public static final long serialVersionUID = 1231142L;
    protected Room room;
    protected Course course;

    public Student(Credentials credentials)
    {
        super(credentials,0);
    }

    public boolean checkRoomAvailability(Room r)
    {
        return true;
    }

    public void bookRoom()
    {

    }

    public void findCourse(String course)
    {

    }

    public void addCourse(String course)
    {

    }

    public String toString()
    {
        return (this.credentials.emaill);
    }
}
