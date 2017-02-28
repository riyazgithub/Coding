package com.hack.snippets.pjo;

import com.hack.snippets.GenerateData;

import java.util.ArrayList;
import java.util.List;

public class Class extends AbstractRosterEntity {

    private Course course;

    private List<String> instructor_unique_identifiers = new ArrayList<>();

    private String location;

    private String room;

    private List<String> student_unique_identifiers = new ArrayList<>();

    public Class() {

    }
    public Class(final String uniqueIdentifier, final String name, final Course course, final List<String> instructor_unique_identifiers, final String location, final String source,  final String source_system_identifier) {
        super (name, source, uniqueIdentifier, source_system_identifier);
        this.course = course;
        this.location = location;
        this.instructor_unique_identifiers = instructor_unique_identifiers;
    }

    public String toSqlString() {
        String data = new String();
        data += GenerateData.singleQuote + this.getUnique_identifier() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getName() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getCourse().getUnique_identifier() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getInstructor_unique_identifiers().get(0) + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getInstructor_unique_identifiers().get(1) + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getInstructor_unique_identifiers().get(2) + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getLocation() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getSource() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getSource_system_identifier() + GenerateData.singleQuote;
        return data;
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
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
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
