package com.hack.snippets.pjo;

public class Person extends AbstractRosterEntity {

    private String grade;
    private String managed_apple_id;
    private String first_name;
    private String last_name;
    private String middle_name;
    private String passcode_type;

    public Person() {

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
