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
        return tuesdayVenue;
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
        return wednesdayVenue;
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
        return thursdayVenue;
    }

    public String getFridayTime() {
        return fridayTime;
    }

    public String getFridayVenue() {
        return fridayVenue;
    }

    public String getTutDay() {
        return tutDay;
    }

    public String getTutTime() {
        return tutTime;
    }

    public String getTutVenue() {
        return tutVenue;
    }

    public String getLabDay() {
        return labDay;
    }

    public String getLabTime() {
        return labTime;
    }

    public String getLabVenue() {
        return labVenue;
    }

    public String getPreConditions() {
        return preConditions;
    }

    public String getPostConditions() {
        return postConditions;
    }


}
