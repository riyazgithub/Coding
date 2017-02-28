package com.hack.snippets.pjo;

import com.hack.snippets.GenerateData;

public class Location extends AbstractRosterEntity {

    public Location() {

    }

    public Location(final String name, final String uniqueIdentifier) {
        super(name, uniqueIdentifier);
    }

    public Location(final String name, final String source, final String uniqueIdentifier, final String source_system_identifier) {
        super (name, source, uniqueIdentifier, source_system_identifier);
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
