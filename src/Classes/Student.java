package Classes;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Student extends Person implements Serializable{

    public static final long serialVersionUID = 1231142L;
    protected Room room;
    protected Course course;

    protected String roomCheck, timeCheck, dayCheck;
    public Student(Credentials credentials)
    {
        super(credentials,0);
    }

    public Student(String roomCheck,String timeCheck,String dayCheck)
    {
        this.roomCheck = roomCheck;
        this.timeCheck = timeCheck;
        this.dayCheck = dayCheck;
    }


    public boolean checkRoomAvailability() throws IOException, ClassNotFoundException {
        Main ob = new Main();
        ArrayList<Course> routine = Main.deserializeCSV();
        if(dayCheck.equalsIgnoreCase("Monday"))
        {
            for(int i = 1; i < routine.size(); i++)
            {
                if(routine.get(i).getMondayVenue().equalsIgnoreCase(roomCheck) && routine.get(i).getMondayTime().equalsIgnoreCase(timeCheck))
                {
                    return false;
                }
            }
            return true;
        }
        else if (dayCheck.equalsIgnoreCase("Tuesday"))
        {
            for(int i = 1; i < routine.size(); i++)
            {
                if(routine.get(i).getTuesdayVenue().equalsIgnoreCase(roomCheck) && routine.get(i).getTuesdayTime().equalsIgnoreCase(timeCheck))
                {
                    return false;
                }
            }
            return true;
        }
        else if(dayCheck.equalsIgnoreCase("Wednesday"))
        {
            for(int i = 1; i < routine.size(); i++)
            {
                if(routine.get(i).getWednesdayVenue().equalsIgnoreCase(roomCheck) && routine.get(i).getWednesdayTime().equalsIgnoreCase(timeCheck))
                {
                    return false;
                }
            }
            return true;
        }
        else if(dayCheck.equalsIgnoreCase("Thursday"))
        {
            for(int i = 1; i < routine.size(); i++)
            {
                if(routine.get(i).getThursdayVenue().equalsIgnoreCase(roomCheck) && routine.get(i).getThursdayTime().equalsIgnoreCase(timeCheck))
                {
                    return false;
                }
            }
            return true;
        }
        else if(dayCheck.equalsIgnoreCase("Friday"))
        {
            for(int i = 1; i < routine.size(); i++)
            {
                if(routine.get(i).getFridayVenue().equalsIgnoreCase(roomCheck) && routine.get(i).getFridayTime().equalsIgnoreCase(timeCheck))
                {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public void bookRoom()throws IOException, ClassNotFoundException
    {
        Main ob = new Main();
        ArrayList<Course> routine = Main.deserializeCSV();
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
