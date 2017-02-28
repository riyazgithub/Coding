package com.hack.snippets.pjo;

import com.hack.snippets.GenerateData;

public class Person extends AbstractRosterEntity {

    private String person_number;
    private String first_name;
    private String last_name;
    private String middle_name;
    private String grade;
    private String email_address;
    private String managed_apple_id;
    private String passcode_type;
    private String location_id;

    public Person() {

    }

    public Person(final String uniqueIdentifier, final String person_number, final String first_name, final String middle_name, final String last_name,
      final String grade, final String email_address, final String managed_apple_id, final String passcode_type, final String location_id, final String source,  final String source_system_identifier) {
        super (first_name, source, uniqueIdentifier, source_system_identifier);
        this.person_number = person_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.grade = grade;
        this.email_address = email_address;
        this.managed_apple_id = managed_apple_id;
        this.passcode_type = passcode_type;
        this.location_id = location_id;
    }

    public String toSqlString() {
        String data = new String();
        data += GenerateData.singleQuote + this.getUnique_identifier() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getPerson_number() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getFirst_name() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getMiddle_name() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getLast_name() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getGrade() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getEmail_address() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getManaged_apple_id() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getPasscode_type() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getLocation_id() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getSource() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getSource_system_identifier() + GenerateData.singleQuote;
        return data;
    }

    public String getPerson_number() {
        return person_number;
    }

    public void setPerson_number(String person_number) {
        this.person_number = person_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return the managed_apple_id
     */
    public String getManaged_apple_id() {
        return managed_apple_id;
    }

    /**
     * @param managed_apple_id the managed_apple_id to set
     */
    public void setManaged_apple_id(String managed_apple_id) {
        this.managed_apple_id = managed_apple_id;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the middle_name
     */
    public String getMiddle_name() {
        return middle_name;
    }

    /**
     * @param middle_name the middle_name to set
     */
    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    /**
     * @return the passcode_type
     */
    public String getPasscode_type() {
        return passcode_type;
    }

    /**
     * @param passcode_type the passcode_type to set
     */
    public void setPasscode_type(String passcode_type) {
        this.passcode_type = passcode_type;
    }
}
