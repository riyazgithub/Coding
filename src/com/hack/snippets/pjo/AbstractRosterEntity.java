package com.hack.snippets.pjo;


import com.hack.snippets.GenerateData;

public class AbstractRosterEntity {

    private String name;

    private String source;

    private String source_system_identifier;

    private String unique_identifier;

    public AbstractRosterEntity() {

    }

    public AbstractRosterEntity(final String name, final String uniqueIdentifier) {
        this.name = name;
        this.unique_identifier = uniqueIdentifier;
    }

    public AbstractRosterEntity(final String name, final String source, final String uniqueIdentifier, final String source_system_identifier) {
        this.name = name;
        this.unique_identifier = uniqueIdentifier;
        this.source = source;
        this.source_system_identifier = source_system_identifier;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return the source_system_identifier
     */
    public String getSource_system_identifier() {
        return source_system_identifier;
    }

    /**
     * @param source_system_identifier the source_system_identifier to set
     */
    public void setSource_system_identifier(String source_system_identifier) {
        this.source_system_identifier = source_system_identifier;
    }

    /**
     * @return the unique_identifier
     */
    public String getUnique_identifier() {
        return unique_identifier;
    }

    /**
     * @param unique_identifier the unique_identifier to set
     */
    public void setUnique_identifier(String unique_identifier) {
        this.unique_identifier = unique_identifier;
    }

    public String toSqlString() {
        String data = new String();
        data += GenerateData.singleQuote + this.getUnique_identifier() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getName() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getSource() + GenerateData.singleQuote + GenerateData.comma;
        data += GenerateData.singleQuote + this.getSource_system_identifier() + GenerateData.singleQuote;
        return data;
    }
}
