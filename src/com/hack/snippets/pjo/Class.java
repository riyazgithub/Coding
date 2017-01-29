package com.hack.snippets.pjo;

import java.util.ArrayList;
import java.util.List;

public class Class extends AbstractRosterEntity {

    private Course course;

    private List<String> instructor_unique_identifiers = new ArrayList<>();

    private Location location;

    private String room;

    private List<String> student_unique_identifiers = new ArrayList<>();

    public Class() {

    }

    /**
     * @return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * @return the instructor_unique_identifiers
     */
    public List<String> getInstructor_unique_identifiers() {
        return instructor_unique_identifiers;
    }

    /**
     * @param instructor_unique_identifiers the instructor_unique_identifiers to set
     */
    public void setInstructor_unique_identifiers(List<String> instructor_unique_identifiers) {
        this.instructor_unique_identifiers = instructor_unique_identifiers;
    }

    /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return the room
     */
    public String getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * @return the student_unique_identifiers
     */
    public List<String> getStudent_unique_identifiers() {
        return student_unique_identifiers;
    }

    /**
     * @param student_unique_identifiers the student_unique_identifiers to set
     */
    public void setStudent_unique_identifiers(List<String> student_unique_identifiers) {
        this.student_unique_identifiers = student_unique_identifiers;
    }
}
