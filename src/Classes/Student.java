package Classes;

public class Student extends Person {
    protected Room room;
    protected Course course;

    Student(String n, String email)
    {
        super(n, email, "Student");
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
}
