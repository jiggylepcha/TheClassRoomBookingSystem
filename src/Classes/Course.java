package Classes;
/**
 * This class stores the details of each course and returns the appropriate function when asked for
 * a particular function.
 *
 * @author Nakul Ramanathan 2016168
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable

{
    public static final long serialVersionUID = 1231162L;

    private String type;
    private String courseName;
    private String courseCode;
    private String instructor;
    private String credits;
    private String acronym;
    private String mondayTime;
    private String mondayVenue;
    private String tuesdayTime;
    private String tuesdayVenue;
    private String wednesdayTime;
    private String wednesdayVenue;
    private String thursdayTime;
    private String thursdayVenue;
    private String fridayTime;
    private String fridayVenue;
    private String tutDay;
    private String tutTime;
    private String tutVenue;
    private String labDay;
    private String labTime;
    private String labVenue;
    private String preConditions;
    private String postConditions;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String tut;
    private String lab;

    /**
     * Constructor to initialise the values
     * @param type Elective/Mandatory
     * @param courseName Course name
     * @param courseCode Course code
     * @param instructor Course instructor
     * @param credits No. of credits
     * @param acronym Course acronymn
     * @param monday Time and venue
     * @param tuesday Time and venue
     * @param wednesday Time and venue
     * @param thursday Time and venue
     * @param friday Time and venue
     * @param tut Time and venue
     * @param lab Time and venue
     * @param preConditions Course prerequisites
     * @param postConditions Course postconditions
     */
    Course(String type,
            String courseName,
            String courseCode,
            String instructor,
            String credits,
            String acronym,
            String monday,
            String tuesday,
            String wednesday,
            String thursday,
            String friday,
            String tut,
            String lab,
            String preConditions,
            String postConditions)
    {
        this.type = type;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructor = instructor;
        this.credits = credits;
        this.acronym = acronym;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.tut = tut;
        this.lab = lab;
        this.preConditions = preConditions;
        this.postConditions = postConditions;
    }

    /**
     * These functions are the getters for various course info*/

    public String getType() {
        return type;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getCredits() {
        return credits;
    }

    public String getAcronym() {
        return acronym;
    }

    /**
     * Returns monday time
     * @return Monday time. If no class then returns '-'
     */
    public String getMondayTime() {
        if (monday.contains("$")) {
            mondayTime = monday.substring(0, monday.indexOf("$"));
            return mondayTime;
        }
        else
        {
            return monday;
        }
    }
    /**
     * Returns Monday venue
     * @return Monday venue. If no class then returns '-'
     */
    public String getMondayVenue() {
        if (monday.contains("$")) {
            mondayVenue = monday.substring(monday.indexOf("$") + 1);
            return mondayVenue;
        }
        else
        {
            return monday;
        }
    }
    /**
     * Returns Tuesday time
     * @return Tuesday time. If no class then returns '-'
     */
    public String getTuesdayTime() {
        if (tuesday.contains("$")) {
            tuesdayTime = tuesday.substring(0, tuesday.indexOf("$"));
            return tuesdayTime;
        }
        else
        {
            return tuesday;
        }
    }
    /**
     * Returns Tuesday venue
     * @return Tuesday venue. If no class then returns '-'
     */
    public String getTuesdayVenue() {
        if (tuesday.contains("$")) {
            tuesdayVenue = tuesday.substring(tuesday.indexOf("$") + 1);
            return tuesdayVenue;
        }
        else
        {
            return tuesday;
        }
    }
    /**
     * Returns Wednesday time
     * @return Wednesday time. If no class then returns '-'
     */
    public String getWednesdayTime() {
        if (wednesday.contains("$")) {
            wednesdayTime = wednesday.substring(0, wednesday.indexOf("$"));
            return wednesdayTime;
        }
        else
        {
            return wednesday;
        }
    }
    /**
     * Returns Wednesday venue
     * @return Wednesday venue. If no class then returns '-'
     */
    public String getWednesdayVenue() {
        if (wednesday.contains("$")) {
            wednesdayVenue = wednesday.substring(wednesday.indexOf("$") + 1);
            return wednesdayVenue;
        }
        else
        {
            return wednesday;
        }
    }
    /**
     * Returns Thursday time
     * @return Thursday time. If no class then returns '-'
     */
    public String getThursdayTime() {
        if (thursday.contains("$")) {
            thursdayTime = thursday.substring(0, thursday.indexOf("$"));
            return thursdayTime;
        }
        else
        {
            return thursday;
        }
    }
    /**
     * Returns Thursday Venue
     * @return Thursday Venue. If no class then returns '-'
     */
    public String getThursdayVenue() {
        if (thursday.contains("$")) {
            thursdayVenue = thursday.substring(thursday.indexOf("$") + 1);
            return thursdayVenue;
        }
        else
        {
            return thursday;
        }
    }
    /**
     * Returns Friday time
     * @return Friday time. If no class then returns '-'
     */
    public String getFridayTime() {
        if (friday.contains("$")) {
            fridayTime = friday.substring(0, friday.indexOf("$"));
            return fridayTime;
        }
        else
        {
            return friday;
        }
    }
    /**
     * Returns Friday Venue
     * @return Friday Venue. If no class then returns '-'
     */
    public String getFridayVenue() {
        if (friday.contains("$")) {
            fridayVenue = friday.substring(friday.indexOf("$") + 1);
            return fridayVenue;
        }
        else
        {
            return friday;
        }
    }

    /**
     *
     * @return Returns the Tutorial Day
     */
    public String getTutDay() {
        int index;
        String day1, day2;
        if(tut.contains("$"))
        {
            int counter = 0;
            for(int i = 0; i < tut.length(); i++)
            {
                 char c = tut.charAt(i);
                 if (c == ':')
                 {
                    counter++;
                 }
                 if(counter == 3)
                 {
                     index = i;
                     day1 = tut.substring(0, index);
                     day1 = day1.trim();
                     //System.out.println(day1);
                     day2 = tut.substring(index);
                     day2 = day2.trim();

                     if(day2.contains("$"))
                     {
                         return day1.substring(0, day1.indexOf("$")) + day2.substring(0, day2.indexOf("$"));
                     }
                     else
                     {
                         return tut.substring(0,tut.indexOf("$")); // If only one day is there
                     }
                 }
            }
            return tut.substring(0,tut.indexOf("$")); // If only one day is there
        }
        else
        {return tut;}
    }
    /**
     * @return Returns Tutorial Timing
     */
    public String getTutTime() {
        if(tut.contains("$"))
        {
            int counter = 0, indexStart = 0, indexEnd = 0, secondDollar=0;
            boolean flag1 = true, flag2 = true, flag3 = true;
            for (int i = 0; i < tut.length(); i++)
            {
                char c = tut.charAt(i);
                if(c == '$')
                {
                    counter ++;
                }
                if (counter == 2 && flag1 == true)
                {
                    secondDollar = i;
                    flag1 = false;
                }
                if(counter == 3 && flag2 == true)
                {
                    indexStart = i;
                    flag2 = false;
                }
                if (counter == 4 && flag3 == true)
                {
                    indexEnd = i;
                    flag3 = false;
                }
            }
            //System.out.println(secondDollar);
            if (counter > 2)
            {
                // There are two tut days
                return tut.substring(tut.indexOf("$")+1, secondDollar) + "&" + tut.substring(indexStart+1,indexEnd);

            }
            else
            {
                // There is only one tut day
                return tut.substring(tut.indexOf("$")+1,secondDollar);
            }
        }else
        {
        return tut;}
    }

    /**
     *
     * @return Returns the Tutorial Venue
     */
    public String getTutVenue() {
        if (tut.contains("$"))
        {
            int posOfSeconddol=tut.indexOf("$",tut.indexOf("$")+1);
            int posOfCol=tut.indexOf(":", posOfSeconddol);
            String ret=tut.substring(posOfSeconddol+1, posOfCol-1);
            if(tut.substring(posOfCol).length() >4)
            {
                int posOfDol=tut.substring(posOfCol).indexOf("$", tut.substring(posOfCol).indexOf("$")+1);
                int posOfSCol=tut.substring(posOfCol).indexOf(":", posOfDol);
                ret+="&"+tut.substring(posOfCol).substring(posOfDol+1, posOfSCol);
            }

            return ret;
        }
        else {
            return tut;
        }
    }

    /**
     *
     * @return Returns the Lab days
     */
    public String getLabDay() {
        if (lab.contains("$"))
        {
            return lab.substring(0, lab.indexOf(":")-1);
        }
        else {
            return lab;
        }
    }

    /**
     *
     * @return Returns the Lab timings
     */
    public String getLabTime() {
        if(lab.contains("$"))
        {
            return lab.substring(lab.indexOf("$") + 1,lab.lastIndexOf("$"));
        }
        else {
            return lab;
        }
    }
    /**
     * @return Returns the Lab venue
     */
    public String getLabVenue() {
        if(lab.contains("$"))
        {
            return lab.substring(lab.lastIndexOf("$")+1);
        }
        else {
            return lab;
        }
    }

    /**
     *
     * @return Returns the preconditions
     */
    public String getPreConditions() {
        return preConditions;
    }

    /**
     *
     * @return Returns the postconditions
     */
    public String getPostConditions() {
        return postConditions;
    }
}