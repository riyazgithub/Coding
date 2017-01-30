package com.hack.snippets.pjo;

import com.hack.snippets.GenerateData;

/**
 * Created by rafthab on 1/30/17.
 */
public class Rosters extends AbstractRosterEntity{
    private String class_id;

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    private String student_id;
    public Rosters() {

    }

    public Rosters(final String uniqueIdentifier, final String class_id, final String student_id, final String source, final String source_system_identifier ) {
        super (null, source, uniqueIdentifier, source_system_identifier);
        this.class_id = class_id;
        this.student_id = student_id;

    }

    public String toSqlString() {
        String data = new String();
        data += GenerateData.singleQuote + this.getUnique_identifier() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getClass_id() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getStudent_id() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getSource() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getSource_system_identifier() + GenerateData.singleQuote;
        return data;
    }

}
