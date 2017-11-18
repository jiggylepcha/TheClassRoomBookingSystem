package Classes;
/**
 * This class contains the details of the student class.
 * This class also searches and adds courses for a particular student.
 * @author Nakul Ramanathan
 * @author Jigme Lobsang Lepcha
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student extends Person implements Serializable{

    public static final long serialVersionUID = 1231142L;
    protected Room room;
    protected Course course;

    protected String roomCheck, timeCheck, dayCheck;

    /**
     * Constructor to set the credentials
     * @param credentials Sets the credentials
     */
    public Student(Credentials credentials)
    {
        super(credentials,0);
    }

    /**
     * Constructor for student class
     * @param roomCheck Room to be checked
     * @param timeCheck Time to be checked
     * @param dayCheck Day to be checked
     */
    public Student(String roomCheck,String timeCheck,String dayCheck)
    {
        this.roomCheck = roomCheck;
        this.timeCheck = timeCheck;
        this.dayCheck = dayCheck;
    }


    private String email;
    /**
     * Getter for the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of a student
     * @param email Email of the student
     */
    public Student(String email)
    {
        this.email = email;
    }

    /**
     * Checks room availability.
     * @return true if the room is not available for booking else return false
     * @throws IOException
     * @throws ClassNotFoundException
     */
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

    /**
     * Books a room when clicked
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void bookRoom()throws IOException, ClassNotFoundException
    {
        Main ob = new Main();
        ArrayList<Course> routine = Main.deserializeCSV();
    }

    /**
     * Searches for a room
     * @param course String which contains the course name
     */
    public void findCourse(String course)
    {

    }

    static String UID;

    /**
     * Checks whether the course is registered by the student or not
     * @param course Course name
     * @return true if user registered for the particular course
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static boolean addCourse(String course) throws IOException, ClassNotFoundException {
        HashMap<String, String> map = deserialiseStudent();
        String value = map.get(UID);
        if(!value.contains(course)) {
            System.out.println("User did not register this course: ");
            System.out.println("This is the value to be put into the value " +(value+course));
            map.put(UID, value + "&" + course);
            serialiseStudent(map);
            return false;  // Course is not registered when false
        }
        return true; // Course is already registered when true
    }

    /**
     * Gets the username and stores it in a separate database for course registration.
     * @param userID email address
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void getUID(String userID) throws IOException, ClassNotFoundException {
        UID = userID;
        HashMap<String, String> userMap = deserialiseStudent();
        if(!userMap.containsKey(UID)) {
            userMap.put(UID, "&");
        }
        for(Map.Entry<String, String> entry: userMap.entrySet())
        {
            System.out.println("Key " + entry.getKey() +" ## "+"Value "+entry.getValue());
        }
        serialiseStudent(userMap);
        //System.out.println(userMap.get(UID));
    }

    /**
     * Serialises the HashMap
     * @param map HashMap containing email as the key and course as the key
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void serialiseStudent(HashMap<String,String> map)throws IOException, ClassNotFoundException
    {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("studentInfo.ser"));
            out.writeObject(map);
        } finally {
            out.close();
        }
    }

    /**
     * Deserialises the HashMap
     * @return HashMap
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static HashMap<String,String > deserialiseStudent() throws IOException, ClassNotFoundException {
        ObjectInputStream in=null;
        HashMap<String, String> s1=null;
        try {
            in=new ObjectInputStream(new FileInputStream("studentInfo.ser"));
            s1=(HashMap<String, String>) in.readObject();
        }
        finally {
            in.close();
        }

        return s1;
    }

    /**
     * toString method which overrides the Object class toString method
     * @return email address
     */
    public String toString()
    {
        return (this.credentials.emaill);
    }

}
