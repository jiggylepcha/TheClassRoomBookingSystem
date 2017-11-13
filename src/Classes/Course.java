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

    Course(String type,
            String courseName,
            String courseCode,
            String instructor,
            String credits,
            String acronym,
            String mondayTime,
            String mondayVenue,
            String tuesdayTime,
            String tuesdayVenue,
            String wednesdayTime,
            String wednesdayVenue,
            String thursdayTime,
            String thursdayVenue,
            String fridayTime,
            String fridayVenue,
            String tutDay,
            String tutTime,
            String tutVenue,
            String labDay,
            String labTime,
            String labVenue,
            String preConditions,
            String postConditions)
    {
        this.type = type;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructor = instructor;
        this.credits = credits;
        this.acronym = acronym;
        this.mondayTime = mondayTime;
        this.mondayVenue = mondayVenue;
        this.tuesdayTime = tuesdayTime;
        this.tuesdayVenue = tuesdayVenue;
        this.wednesdayTime = wednesdayTime;
        this.wednesdayVenue = wednesdayVenue;
        this.thursdayTime = thursdayTime;
        this.thursdayVenue = thursdayVenue;
        this.fridayTime = fridayTime;
        this.fridayVenue = fridayVenue;
        this.tutDay = tutDay;
        this.tutTime = tutTime;
        this.tutVenue = tutVenue;
        this.labDay = labDay;
        this.labTime = labTime;
        this.labVenue = labVenue;
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
        return mondayTime;
    }

    public String getMondayVenue() {
        return mondayVenue;
    }

    public String getTuesdayTime() {
        return tuesdayTime;
    }

    public String getTuesdayVenue() {
        return tuesdayVenue;
    }

    public String getWednesdayTime() {
        return wednesdayTime;
    }

    public String getWednesdayVenue() {
        return wednesdayVenue;
    }

    public String getThursdayTime() {
        return thursdayTime;
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
