package Classes;

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

    public String getLabDay() {
        if (lab.contains("$"))
        {
            return lab.substring(0, lab.indexOf(":")-1);
        }
        else {
            return lab;
        }
    }

    public String getLabTime() {
        if(lab.contains("$"))
        {
            return lab.substring(lab.indexOf("$") + 1,lab.lastIndexOf("$"));
        }
        else {
            return lab;
        }
    }

    public String getLabVenue() {
        if(lab.contains("$"))
        {
            return lab.substring(lab.lastIndexOf("$")+1);
        }
        else {
            return lab;
        }
    }

    public String getPreConditions() {
        return preConditions;
    }

    public String getPostConditions() {
        return postConditions;
    }
}