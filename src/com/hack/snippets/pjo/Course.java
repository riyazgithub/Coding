package com.hack.snippets.pjo;

import com.hack.snippets.GenerateData;

public class Course extends AbstractRosterEntity {

    private String location_id;

    public String getCourse_number() {
        return course_number;
    }

    public void setCourse_number(String course_number) {
        this.course_number = course_number;
    }

    private String course_number;

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public Course() {

    }

    public Course(final String name, final String uniqueIdentifier) {
        super(name, uniqueIdentifier);
    }

    public Course(final String uniqueIdentifier, final String course_number, final String name, final String location_id, final String source, final String source_system_identifier) {
        super (name, source, uniqueIdentifier, source_system_identifier);
        this.location_id = location_id;
        this.course_number = course_number;
    }

    public String toSqlString() {
        String data = new String();
        data += GenerateData.singleQuote + this.getUnique_identifier() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getCourse_number() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getName() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getLocation_id() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getSource() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getSource_system_identifier() + GenerateData.singleQuote;
        return data;
    }
}
